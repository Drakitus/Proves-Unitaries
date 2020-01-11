package pharmacy;

import data.Exceptions.PatientContrException;
import data.PatientContr;
import data.ProductID;

import java.math.BigDecimal;

public class ProductSaleLine {

    private ProductID prodID;
    private BigDecimal price;
    private PatientContr contr;

    ProductSaleLine(ProductID prodID, BigDecimal price, PatientContr contr) {
        this.prodID = prodID;
        this.price = price;
        this.contr = contr;
    }

    public ProductID getProdID() { return prodID; }

    public void setProdID(ProductID prodID) { this.prodID = prodID; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public PatientContr getContr() { return contr; }

    public void setContr(PatientContr contr) { this.contr = contr; }

    public BigDecimal getSubTotal() throws PatientContrException {
        return price.multiply(contr.getPatientContribution());
    }
}
