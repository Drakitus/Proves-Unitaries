package data;

import java.math.BigDecimal;
import java.util.Objects;

public class PatientContr {

    private final BigDecimal contribution;

    public PatientContr(int contribution) {
        Objects.requireNonNull(contribution, "The contribution cannot be NULL");

        this.contribution = new BigDecimal(contribution);
    }

    public BigDecimal getContribution() { return contribution; }

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
