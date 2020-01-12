package pharmacy;

import data.Exceptions.PatientContrException;
import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import pharmacy.Exceptions.DispensingNotAvailableException;
import pharmacy.Exceptions.SaleClosedException;
import services.*;
import services.Exceptions.HealthCardException;
import services.Exceptions.NotValidePrescriptionException;
import services.Exceptions.ProductIDException;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.List;

public class DispensingTerminal implements NationalHealthService{

    private HealthCardID hc;
    private HealthCardReader hcr;
    private NationalHealthService sns;
    private Dispensing disp;            //actual dispensing
    private Sale sale;
    private BigDecimal amount;

    public DispensingTerminal(){
    }

    public void getePrescription() throws HealthCardException, NotValidePrescriptionException, ConnectException, DispensingNotAvailableException {
       try {
            hc = hcr.getHealthCardID();
            disp = sns.getePrescription(hc);
       }catch (ConnectException ce){
           throw new ConnectException();
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
            ProductSpecification prodSpec = sns.getProductSpecific(pID);
            PatientContr patCont = sns.getPatientContr(hc);

            sale.addLine(pID,prodSpec.getPrice(),patCont);
            disp.setProductAsDispensed(pID);
        }catch (ConnectException | ProductIDException ce){
            throw new ConnectException();
        }
    }
    public void finalizeSale() throws SaleClosedException, PatientContrException {
        //sale.calculateFinalAmount();
        amount =  sale.getAmount();
        sale.setClosed();
        disp.setCompleted();
    }

    public Dispensing getActDispensing(){ return disp; }

    public Sale getSale(){
        return sale;
    }

    public void setSNS(NationalHealthService sns){ this.sns = sns;}

    public void setHCR(HealthCardReader hcr){ this.hcr = hcr; }

    public BigDecimal getAmount() { return amount; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }


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
