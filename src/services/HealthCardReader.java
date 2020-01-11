package services;

import data.HealthCardID;
import services.Exceptions.HealthCardException;

public interface HealthCardReader {
    HealthCardID getHealthCardID() throws HealthCardException;
}
