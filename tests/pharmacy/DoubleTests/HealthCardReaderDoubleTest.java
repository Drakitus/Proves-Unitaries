package pharmacy.DoubleTests;

import data.HealthCardID;
import services.Exceptions.HealthCardException;
import services.HealthCardReader;

public class HealthCardReaderDoubleTest implements HealthCardReader {
    @Override
    public HealthCardID getHealthCardID() throws HealthCardException {

        return new HealthCardID("ABCD1234567890");

    }
}
