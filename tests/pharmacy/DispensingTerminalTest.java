package pharmacy;

import data.Exceptions.PatientContrException;
import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pharmacy.DoubleTests.HealthCardReaderDoubleTest;
import pharmacy.DoubleTests.SNSDoubleTest;
import pharmacy.Exceptions.DispensingNotAvailableException;
import pharmacy.Exceptions.SaleClosedException;
import services.Exceptions.HealthCardException;
import services.Exceptions.NotValidePrescriptionException;
import services.Exceptions.ProductIDException;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DispensingTerminalTest {

    private DispensingTerminal dt;

    private Dispensing createDispensing() throws ProductIDException {
        byte nOrder = 13;
        List<MedicineDispensingLine> prescription = new ArrayList<>();
        prescription.add(new MedicineDispensingLine(new ProductID("123456789012")));
        Dispensing dispensingExpected = new Dispensing(nOrder, new Date(), new Date(), prescription);
        return dispensingExpected;
    }

    @BeforeEach
    public void setUp(){
        dt = new DispensingTerminal();
        dt.setHCR(new HealthCardReaderDoubleTest());
        dt.setSNS(new SNSDoubleTest());
    }
    @Test
    public void getePrescriptionTest() throws ProductIDException, HealthCardException, DispensingNotAvailableException, ConnectException, NotValidePrescriptionException {

        Dispensing dispensingExpected = createDispensing();

        dt.getePrescription();

        assertEquals(dispensingExpected.dispensingEnabled(), dt.getActDispensing().dispensingEnabled());
    }

    @Test
    public void intNewSaleTest() throws DispensingNotAvailableException, NotValidePrescriptionException, HealthCardException, ConnectException, ProductIDException {

        dt.getePrescription();
        dt.initNewSale(5);
        Sale sale = new Sale(5);

        assertEquals(sale.isClosed(),dt.getSale().isClosed());
    }

   /* @Test
    public void enterProductTest() throws HealthCardException, ConnectException, DispensingNotAvailableException, SaleClosedException, NotValidePrescriptionException {
        dt.getePrescription("A".charAt(0));
        dt.initNewSale(5);
        dt.enterProduct(new ProductID("123456789012"));

        List<ProductSaleLine> productSaleLines = dt.getSale().getProductSaleLine();
        assertEquals(new ProductID("123456789012"), productSaleLines.get(productSaleLines.size()-1).getProdID());
        assertTrue(dt.getActDispensing().getisAcquired(new ProductID("123456789012")));
    }*/
    @Test
    public void finalizeSaleTest() throws HealthCardException, ConnectException, DispensingNotAvailableException,
                                        SaleClosedException, NotValidePrescriptionException, PatientContrException {
        dt.getePrescription();
        dt.initNewSale(5);
        dt.enterProduct(new ProductID("1234567890"));
        dt.finalizeSale();
        assertTrue(dt.getSale().isClosed());
        assertTrue(dt.getActDispensing().isCompleted());
    }
}