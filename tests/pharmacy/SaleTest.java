package pharmacy;

import data.PatientContr;
import data.Exceptions.PatientContrException;
import data.ProductID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pharmacy.Exceptions.SaleClosedException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {

    private Sale sale;
    private PatientContr contr;
    private ProductID productID;
    private List<ProductSaleLine> product_line;

    public static BigDecimal IVA = BigDecimal.valueOf(1.21);

    @BeforeEach
    public void setUp(){
        contr = new PatientContr(BigDecimal.valueOf(30));
        productID = new ProductID("123456789012");
        sale = new Sale(1234);
        product_line = new ArrayList<>();
    }

    @Test
    @DisplayName("S'afegeix una lina de venta")
    public void addLineTest() throws SaleClosedException {
        BigDecimal price = BigDecimal.valueOf(23);
        ProductSaleLine psl = new ProductSaleLine(productID,price, contr);

        product_line.add(0,psl);
        assertEquals(psl,product_line.get(0));

    }

    @Test
    @DisplayName("Calcular la quantitat amb només un preu")
    public void getAmountJustOnePrice() throws SaleClosedException, PatientContrException {
        BigDecimal price = BigDecimal.valueOf(4.8);
        sale.addLine(productID, price, contr);

        assertEquals(price.multiply(IVA).multiply(contr.getPatientContribution()), sale.getAmount());
    }

    @Test
    @DisplayName("Calcular la quantitat amb varis preus")
    public void getAmountMorePrices() throws SaleClosedException, PatientContrException {

        ProductID firstProd = new ProductID("123456789012");
        BigDecimal price1 = BigDecimal.valueOf(3.2);

        ProductID secondProd = new ProductID("210987654321");
        BigDecimal price2 = BigDecimal.valueOf(4.2);


        sale.addLine(firstProd, price1, contr);
        sale.addLine(secondProd,price2,contr);

        BigDecimal expectedFirstSubtotal = price1.multiply(contr.getPatientContribution());
        BigDecimal expectedSecondSubtotal = price2.multiply(contr.getPatientContribution());
        BigDecimal expectedSubtotal = expectedFirstSubtotal.add(expectedSecondSubtotal);
        BigDecimal expectedAmount = expectedSubtotal.multiply(IVA);


        assertEquals(expectedAmount, sale.getAmount());
    }
    @Test
    @DisplayName("Donar la venda per finalitzada")
    public void setClosedTest(){
        sale.setClosed();
        assertTrue(sale.isClosed());
    }

    @Test
    @DisplayName("Comprovar si la venda esta tancada")
    public void isClosedTest(){
        assertFalse(sale.isClosed());
    }



}
