package pharmacy;
import data.Exceptions.PatientContrException;
import data.PatientContr;
import data.ProductID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSaleLineTest {
    private ProductID prodID;
    private BigDecimal price = BigDecimal.valueOf(10);
    private PatientContr contr;
    private ProductSaleLine productSaleLine;
    private BigDecimal subTotal;

    @BeforeEach
    public void setUp() {
        prodID = new ProductID("012345678912");
        contr = new PatientContr(price);
        productSaleLine = new ProductSaleLine(prodID,price,contr);
    }

    @Test
    @DisplayName("Obtindre el producte")
    public void getProductIDTest(){
        assertEquals(productSaleLine.getProdID(),prodID);
    }

    @Test
    @DisplayName("Modificar el producte")
    public void setProductIDTest(){
        ProductID productID2 = new ProductID("123456789009");
        productSaleLine.setProdID(productID2);
        assertEquals(productSaleLine.getProdID(),productID2);
    }

    @Test
    @DisplayName("Obtindre el preu")
    public void getPriceTest(){
        assertEquals(productSaleLine.getPrice(),price);
    }
    @Test
    @DisplayName("Modificar el preu")
    public void setPriceTest(){
        BigDecimal price2 = BigDecimal.valueOf(20);
        productSaleLine.setPrice(price2);
        assertEquals(productSaleLine.getPrice(),price2);
    }

    @Test
    @DisplayName("Obtindre el contribució")
    public void getContrTest(){
        assertEquals(productSaleLine.getContr(),contr);
    }

    @Test
    @DisplayName("Modificar el contribució")
    public void setContrTest(){
        BigDecimal price3 = BigDecimal.valueOf(30);
        PatientContr contr2 = new PatientContr(price3);
        productSaleLine.setContr(contr2);
        assertEquals(productSaleLine.getContr(),contr2);
    }

    @Test
    @DisplayName("Obtindre el subtotal")
    public void getSubTotalTest() throws PatientContrException {
        subTotal = productSaleLine.getSubTotal();
        assertEquals(productSaleLine.getSubTotal(),subTotal);
    }

    @Test
    @DisplayName("Obtindre el subtotal2")
    public void getSubTotalTest2() throws PatientContrException {
        BigDecimal price3 = BigDecimal.valueOf(30);
        PatientContr contr2 = new PatientContr(price3);
        productSaleLine.setContr(contr2);
        productSaleLine.setPrice(price3);
        subTotal = productSaleLine.getSubTotal();
        assertEquals(productSaleLine.getSubTotal(),subTotal);
    }
}
