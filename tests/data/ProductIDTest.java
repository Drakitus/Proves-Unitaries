package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductIDTest implements dataTest{

    ProductID productID;
    @BeforeEach
    public void setUp(){
        productID = new ProductID("123456789012");
    }

    @Test
    @DisplayName("No accepta null")
    public void NullThrowsExceptionTest(){
        Throwable exception = assertThrows(NullPointerException.class,
                ()-> {
                    new ProductID(null);
                });
        assertEquals("ProductID cannot be NULL", exception.getMessage());
    }
    @Test
    @DisplayName("No accepta '' ")
    public void BlankThrowsExceptionTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()-> {
                    new ProductID("");
                });
        assertEquals("ProductID cannot be Empty", exception.getMessage());
    }

    @Test
    @DisplayName("No accepta '    ' ")
    public void AllWhiteSpacesThrowsExceptionTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new ProductID("     ");
                });
        assertEquals("ProductID cannot be WhiteSpaces", exception.getMessage());
    }
    @Test
    @DisplayName("Creació d'un ProductID correcte")
    public void addCorrectDataTest() {
        String pID = productID.getProdUPC();
        assertEquals("123456789012",pID);
    }

}
