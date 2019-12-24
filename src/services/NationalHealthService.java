package services;

import data.*;
import pharmacy.*;

import java.net.ConnectException;
import java.util.*;

public interface NationalHealthService {
    Dispensing getePrescription(HealthCardID hcID)
            throws HealthCardException, NotValidePrescriptionException,
            ConnectException;
    PatientContr getPatientContr(HealthCardID hcID) throws ConnectException;
    ProductSpecification getProductSpecific(ProductID pID)
            throws ProductIDException, ConnectException;
    List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp)
            throws ConnectException;
}
