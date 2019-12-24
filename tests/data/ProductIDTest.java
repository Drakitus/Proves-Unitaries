package data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductIDTest implements dataTest{

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
    @DisplayName("Creació d'un ProductID amb dades correctes")
    public void addCorrectDataTest() {
        ProductID productID = new ProductID("001234567890");
        assertEquals("001234567890", productID.getProdUPC());
    }

}
