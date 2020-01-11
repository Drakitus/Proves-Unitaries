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
    @BeforeEach
    public void setUp(){
        dispensing = new Dispensing();
        productID = new ProductID("123456789012");
    }

    @Test
    @DisplayName("Comença dispensació")
    public void dispensingEnabledTest() throws DispensingNotAvailableException {
        Date todayDate = new Date(2009,1,8);
        dispensing.setInitDate(todayDate);
        assertTrue(dispensing.dispensingEnabled());
    }

    @Test
    @DisplayName("Producte dispensat")
    public void setProductAsDispTest() {
        MedicineDispensingLine line = new MedicineDispensingLine(productID);

        dispensing.addLine(line);
        dispensing.setProductAsDispensed(productID);

        assertTrue(dispensing.getLine(productID).isAcquired());
    }

}
