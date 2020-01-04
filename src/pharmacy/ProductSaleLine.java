package pharmacy;

import data.PatientContr;
import data.ProductID;

import java.math.BigDecimal;

public class ProductSaleLine {

    private ProductID prodID;
    private BigDecimal price;
    private PatientContr contr;

    ProductSpecification ps;
    private BigDecimal subTotal;

    ProductSaleLine(ProductID prodID, BigDecimal price, PatientContr contr) {
        this.prodID = prodID;
        this.price = price;
        this.contr = contr;
        this.subTotal = new BigDecimal(0);
    }

    public ProductID getProdID() { return prodID; }

    public void setProdID(ProductID prodID) { this.prodID = prodID; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public PatientContr getContr() { return contr; }

    public void setContr(PatientContr contr) { this.contr = contr; }

    public BigDecimal getSubTotal() { return subTotal; }

    public void setSubTotal(BigDecimal subTotal) { this.subTotal = ps.getPrice().multiply(contr.getContribution()); }

}
