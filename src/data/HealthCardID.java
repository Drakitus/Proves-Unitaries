package data;

import java.util.Objects;

final public class HealthCardID {

    private final String personalID;

    public HealthCardID(String code) {
        Objects.requireNonNull(code, "HealthCardID cannot be NULL");

        if (code.isEmpty()) throw new IllegalArgumentException("HealthCardID cannot be Empty");
        if (code.isBlank()) throw new IllegalArgumentException("HealthCardID cannot be WhiteSpaces");
        if(!codeIsValid()) throw new IllegalArgumentException("HealthCardID is not valid.");
        
        this.personalID = code;
    }
    public String getPersonalID() { return personalID; }

    public boolean codeIsValid(){
        return personalID.length() == 14 && first4Letters(personalID) && last10digits(personalID);
    }

    private boolean first4Letters(String code){
        char [] alphabet = new char[4];
        code.getChars(0,4, alphabet, 0);
        for(int i = 0; i < 4; i++){
            if (!Character.isAlphabetic(alphabet[i])) return false;
        }
        return true;
    }

    private boolean last10digits(String code){
        char [] digit = new char[10];
        code.getChars(4,14, digit, 0);
        for(int i = 0; i < 10; i++){
            if (!Character.isDigit(digit[i])) return false;
        }
        return true;
    }

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
