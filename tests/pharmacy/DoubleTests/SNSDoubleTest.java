package pharmacy.DoubleTests;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import pharmacy.Dispensing;
import pharmacy.ProductSpecification;
import services.Exceptions.HealthCardException;
import services.Exceptions.NotValidePrescriptionException;
import services.Exceptions.ProductIDException;
import services.NationalHealthService;

import java.net.ConnectException;
import java.util.List;

public class NationalHealthServiceDoubleTest implements NationalHealthService {
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
}
