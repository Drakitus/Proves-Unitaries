package pharmacy;

import data.ProductID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ProductSpecificationTest {

    private ProductSpecification ps;
    private BigDecimal price;
    private ProductID prodID;
    private String descr;

    @BeforeEach
    public void setUp(){
        price = new BigDecimal(5);
        prodID = new ProductID("000123456789");
        descr = "Ayuda a aliviar los síntomas de la gripe y el resfriado";
        ps = new ProductSpecification(prodID,descr, price);
    }

    @Test
    @DisplayName("Obtindre la descripció")
    public void GetDescriptionTest(){
        String descripcio = "Ayuda a aliviar los síntomas de la gripe y el resfriado";
        assertEquals(descripcio,ps.getDescription());
    }

    @Test
    @DisplayName("Crear nova descripció")
    public void SetDescriptionTest(){
        String descripcio = "Contiene ibuprofeno como principio activo";
        ps.setDescription("Contiene ibuprofeno como principio activo");
        assertEquals(descripcio,ps.getDescription());
    }

    @Test
    @DisplayName("Obtindre el preu")
    public void GetPriceTest(){
        BigDecimal price = new BigDecimal(5);
        assertEquals(price,ps.getPrice());
    }

    @Test
    @DisplayName("Ficar nou preu")
    public void SetPriceTest(){
        BigDecimal price = new BigDecimal(9.6);
        ps.setPrice(new BigDecimal(9.6));
        assertEquals(price,ps.getPrice());
    }

}
