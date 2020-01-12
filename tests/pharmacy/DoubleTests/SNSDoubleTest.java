package pharmacy.DoubleTests;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import pharmacy.Dispensing;
import pharmacy.MedicineDispensingLine;
import pharmacy.ProductSpecification;
import services.Exceptions.HealthCardException;
import services.Exceptions.NotValidePrescriptionException;
import services.Exceptions.ProductIDException;
import services.NationalHealthService;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SNSDoubleTest implements NationalHealthService {
    @Override
    public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
        byte nOrder = 13;
        List<MedicineDispensingLine> prescrition = new ArrayList<>();
        prescrition.add(new MedicineDispensingLine(new ProductID("123456789012")));
        Dispensing dispensing = new Dispensing(nOrder, new Date(115, 1, 1), new Date(125, 1,1),prescrition);
        return dispensing;
    }

    @Override
    public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
        return new PatientContr(new BigDecimal(0.765));
    }

    @Override
    public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
        if (pID.getProdUPC().endsWith("0000")){
            throw new ProductIDException("Aquest producte no es troba en catàleg!");
        }
        return new ProductSpecification(pID, "Diazepam/BAYER/100g", new BigDecimal("5.23"));
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
        try{
            List<Dispensing> list = new ArrayList<>();
            Dispensing oldDisp = getePrescription(hcID);
            list.add(oldDisp);
            list.add(disp);
            return list;

        }catch (HealthCardException | NotValidePrescriptionException hce){}
        return null;
    }
}
