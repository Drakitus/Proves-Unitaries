package data;

import java.util.Objects;

final public class HealthCardID {

    private final String personalID;

    public HealthCardID(String code) {
        Objects.requireNonNull(code, "HealthCardID cannot be NULL");

        if (code.isEmpty()) throw new IllegalArgumentException("HealthCardID cannot be Empty");
        if (code.isBlank()) throw new IllegalArgumentException("HealthCardID cannot be WhiteSpaces");
        if(!codeIsValid(code)) throw new IllegalArgumentException("HealthCardID is not valid.");
        
        this.personalID = code;
    }

    public boolean codeIsValid(String code){
        char [] alphabet = new char[4];
        char [] digit = new char[10];

        if(code.length() != 14){
            throw new IllegalArgumentException("HealthCardID is not valid.");
        }
        code.getChars(0,4,alphabet,0);
        for(int i = 0; i < 4; i++){
            if (!Character.isAlphabetic(alphabet[i])) return false;
        }
        code.getChars(4,14,digit,0);
        for(int i = 0; i < 10; i++){
            if (!Character.isDigit(digit[i])) return false;
        }
        return true;
    }

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
