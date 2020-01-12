package pharmacy;

import data.ProductID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pharmacy.Exceptions.DispensingNotAvailableException;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class DispensingTest {

    private Dispensing dispensing;
    private ProductID productID;
    private Date initDate = new Date();
    private Date finalDate = new Date();

    @BeforeEach
    public void setUp(){
        byte nOrder = 1;
        dispensing = new Dispensing(nOrder,initDate,finalDate);
        productID = new ProductID("123456789012");
    }

    @Test
    @DisplayName("Comença dispensació")
    public void dispensingEnabledTest() throws DispensingNotAvailableException {
        initDate = new Date(1800,2,15);
        finalDate = new Date(1850,1,10);
        dispensing.setInitDate(initDate);
        dispensing.setFinalDate(finalDate);
        assertTrue(dispensing.dispensingEnabled());
    }

    @Test
    @DisplayName("Identificar dispensació")
    public void setnOrderTest() {
        dispensing.setnOrder((byte) 1);
        assertEquals(dispensing.getnOrder(),1);
        dispensing.setnOrder((byte) 2);
        assertEquals(dispensing.getnOrder(),2);
    }

    @Test
    @DisplayName("Acabar dispensació")
    public void finishDispensingTest() {
        dispensing.setCompleted();
        assertTrue(dispensing.isCompleted());
    }

    @Test
    @DisplayName("Producte dispensat")
    public void setProductAsDispTest() {
        MedicineDispensingLine line = new MedicineDispensingLine(productID);
        dispensing.addLine(line);
        dispensing.setProductAsDispensed(productID);
        dispensing.getLine(productID).setAcquired(productID);
        assertTrue(dispensing.getLine(productID).isAcquired());
    }

    @Test
    @DisplayName("Actualitzar dispensació")
    public void setDispensingTest() {
        Dispensing dispensing2 = new Dispensing((byte) 2,initDate,finalDate);
        ProductID productID2 = new ProductID("098765432109");
        MedicineDispensingLine line2 = new MedicineDispensingLine(productID2);
        dispensing2.addLine(line2);
        dispensing2.setProductAsDispensed(productID2);
        dispensing2.getLine(productID2).setAcquired(productID2);
        dispensing.setPresc(dispensing2.getPresc());
        assertTrue(dispensing.getLine(productID2).isAcquired());
    }
}