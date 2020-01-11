package pharmacy;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import pharmacy.Exceptions.DispensingNotAvailableException;
import pharmacy.Exceptions.SaleClosedException;
import services.*;
import services.Exceptions.HealthCardException;
import services.Exceptions.NotValidePrescriptionException;
import services.Exceptions.ProductIDException;

import java.net.ConnectException;
import java.util.Date;
import java.util.List;

public class DispensingTerminal implements NationalHealthService{

    private HealthCardID hc;
    private HealthCardReader hcr;
    private NationalHealthService sns;
    private Dispensing disp;            //actual dispensing
    private Sale sale;

    public DispensingTerminal(){
        this.hc = null;
        this.hcr = null;
        this.sns = null;
        this.disp = null;
    }

    public void getePrescription(char option) throws HealthCardException, NotValidePrescriptionException, ConnectException, DispensingNotAvailableException {
       try {
            hc = hcr.getHealthCardID();
            disp = sns.getePrescription(hc);
       }catch (ConnectException ce){
           throw new ConnectException();
       }
       if(!hc.codeIsValid()){
            throw new HealthCardException();
       }
       if (!disp.dispensingEnabled()){
            throw new DispensingNotAvailableException("The dispensation is not available");
       }
    }
    public void initNewSale(int saleCode) throws DispensingNotAvailableException {
        sale = new Sale(saleCode);
        if(disp.dispensingEnabled()){
            sale.setDispensing(disp);
        } else {
            throw new DispensingNotAvailableException("The dispensation is not available");
        }
    }
    public void enterProduct(ProductID pID) throws ConnectException, SaleClosedException {
        try {
            ProductSpecification prodSpec = new ProductSpecification(pID,null, null);
            PatientContr patCont = sns.getPatientContr(hc);

            sale.addLine(pID,prodSpec.getPrice(),patCont);
            disp.setProductAsDispensed(pID);
        }catch (ConnectException ce){
            throw new ConnectException();
        }
    }
    public void finalizeSale() throws Exception {
        sale.calculateFinalAmount();
        sale.getAmount();
        sale.setClosed();
        disp.setCompleted();
    }

    @Override
    public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
        return null;
    }

    @Override
    public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
        return null;
    }

    @Override
    public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
        return null;
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
        return null;
    }

    /*public void realizePayment(BigDecimal quantity) { }
    public void realizePayment() { }
    public void printNextDispensingSheet() {  }*/
}
