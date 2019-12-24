package data;

import java.util.Objects;

final public class HealthCardID {

    private final String personalID;

    public HealthCardID(String code) {
        Objects.requireNonNull(code, "HealthCardID cannot be NULL");

        if (code.isEmpty()) throw new IllegalArgumentException("HealthCardID cannot be Empty");
        if (code.isBlank()) throw new IllegalArgumentException("HealthCardID cannot be WhiteSpaces");
        if (!isValidHealthCardID(code)) throw new IllegalArgumentException("HealthCardID has to be a String of numbers");
        
        this.personalID = code;
    }
    private Boolean isValidHealthCardID(String personalID){return personalID.matches("[0-9]+");}
    public String getPersonalID() { return personalID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthCardID hcardID = (HealthCardID) o;
        return personalID.equals(hcardID.personalID);
    }

    @Override
    public int hashCode() { return personalID.hashCode(); }
    
    @Override
    public String toString() {
        return "HealthCardID{" + "personal code='" + personalID + '\'' + '}';
    }
}
