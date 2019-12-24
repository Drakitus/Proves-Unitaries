package data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthCardIDTest {

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
    @DisplayName("Creació d'un HealthCardID amb dades correctes")
    public void addCorrectDataTest() {
        HealthCardID heathCard = new HealthCardID("1234567890");
        assertEquals("1234567890", heathCard.getPersonalID());
    }

}
