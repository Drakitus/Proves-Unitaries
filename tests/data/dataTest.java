package data;

import data.Exceptions.PatientContrException;
import org.junit.jupiter.api.Test;

public interface dataTest {
    @Test
    void NullThrowsExceptionTest();

    @Test
    void BlankThrowsExceptionTest();

    @Test
    void AllWhiteSpacesThrowsExceptionTest();

    @Test
    void addCorrectDataTest() throws PatientContrException;
}
