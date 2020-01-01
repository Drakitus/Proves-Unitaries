package data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthCardIDTest {

    private static HealthCardID hc;
    @BeforeAll
    public static void setUp(){
        hc = new HealthCardID("ABCD123456789012");
    }
    
    @Test
    @DisplayName("No accepta null")
    public void NullThrowsExceptionTest(){
        Throwable exception = assertThrows(NullPointerException.class,
                ()-> {
                    new HealthCardID(null);
                });
        assertEquals("HealthCardID cannot be NULL", exception.getMessage());
    }
    @Test
    @DisplayName("No accepta '' ")
    public void BlankThrowsExceptionTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()-> {
                    new HealthCardID("");
                });
        assertEquals("HealthCardID cannot be Empty", exception.getMessage());
    }

    @Test
    @DisplayName("No accepta '    ' ")
    public void AllWhiteSpacesThrowsExceptionTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new HealthCardID("     ");
                });
        assertEquals("HealthCardID cannot be WhiteSpaces", exception.getMessage());
    }
    @Test
    @DisplayName("Correcta HealthCardID del pacient")
    public void CorrectHealthCardTest(){
        assertEquals(new HealthCardID("ABCD123456789012"),hc);
    }

}
