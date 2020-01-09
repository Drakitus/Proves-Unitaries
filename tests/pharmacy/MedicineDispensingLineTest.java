package pharmacy;

import data.ProductID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MedicineDispensingLineTest {

    private MedicineDispensingLine mdl;
    private ProductID productID;

    @BeforeEach
    public void setUp(){
        productID = new ProductID("000123456789");
        mdl = new MedicineDispensingLine(productID);
    }

    @Test
    @DisplayName("Povar que un producto ha sido adquirido")
    public void SetAdquiredTest(){
        mdl.setAcquired(productID);
        assertTrue(mdl.isAcquired());
    }

    @Test
    @DisplayName("El producte se ha adquirido")
    public void isAdquiredTest(){
        assertFalse(mdl.isAcquired());
    }

    @Test
    @DisplayName("Obtener el producto")
    public void GetMedicineTest(){
        ProductID product = new ProductID("000123456789");
        assertEquals(product,mdl.getMedicine());
    }
}
