package data;

import java.math.BigDecimal;
import java.util.Objects;

public class PatientContr {

    private final BigDecimal contribution;

    public PatientContr(BigDecimal contribution) {
        Objects.requireNonNull(contribution, "The contribution cannot be NULL");

        this.contribution = contribution;
    }


    public BigDecimal getPatientContribution() throws Exception {
        if(contribution.compareTo( new BigDecimal(0.0)) < 0 || contribution.compareTo(new BigDecimal(100.0)) > 0){
            throw new Exception("ERROR. The contribution must be between 0.0 and 100.0");
        }
        return contribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientContr pc = (PatientContr) o;
        return contribution.equals(pc.contribution);
    }
    @Override
    public int hashCode() { return contribution.hashCode(); }

    @Override
    public String toString() {
        return "PatientContr{" + "patient contribution='" + contribution + '\'' + '}';
    }
}
