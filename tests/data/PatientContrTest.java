package data;

import data.Exceptions.PatientContrException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PatientContrTest implements dataTest {

    BigDecimal contribution;
    PatientContr pcontr;

    @BeforeEach
    public void setUp(){
        contribution = new BigDecimal(10);
        pcontr = new PatientContr(contribution);
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
    @DisplayName("Creació d'un ProductID amb dades correctes")
    public void addCorrectDataTest() throws PatientContrException {
        BigDecimal pcont = pcontr.getPatientContribution();
        assertEquals(new BigDecimal(10), pcont);
    }
}
