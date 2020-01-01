package pharmacy;

import data.ProductID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ProductSpecificationTest {

    ProductSpecification ps;
    BigDecimal price;
    ProductID prodUPC;

    @BeforeEach
    public void setUp(){
        price = new BigDecimal(5);
        prodUPC = new ProductID("000123456789");
        ps = new ProductSpecification(prodUPC,"cure tot", price);
    }

    @Test
    @DisplayName("Comprovar que la especificació és correcta")
    public void CorrectProductSpecification(){
        assertEquals(new ProductSpecification(prodUPC,"cure tot", price),ps);
    }
    @Test
    @DisplayName("Comprovar que es la mateixa descripció")
    public void SameDescriptionTest(){
        assertEquals("cure tot",ps.getDescription());
    }
    @Test
    @DisplayName("Comprovar que es el mateix preu")
    public void SamePrice(){
        assertEquals(new BigDecimal(5),ps.getPrice());
    }

}
