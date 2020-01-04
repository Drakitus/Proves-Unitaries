package pharmacy;

import java.math.BigDecimal;

public class ProductSpecification {


    private ProductSaleLine prodID;
    private String description;
    private BigDecimal price;

    public ProductSpecification(ProductSaleLine prodID, String description, BigDecimal price) {
        this.prodID = prodID;
        this.description = description;
        this.price = price;
    }

    public ProductSaleLine getProdID() { return prodID; }

    public void setProdID(ProductSaleLine prodID) { this.prodID = prodID; }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) { this.price = price; }


}
