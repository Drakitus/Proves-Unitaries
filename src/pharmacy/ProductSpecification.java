package pharmacy;

import data.ProductID;

import java.math.BigDecimal;

public class ProductSpecification {


    private ProductID prodID;
    private String description;
    private BigDecimal price;

    public ProductSpecification(ProductID prodID, String description, BigDecimal price) {
        this.prodID = prodID;
        this.description = description;
        this.price = price;
    }

    public ProductID getProdID() { return prodID; }

    public void setProdID(ProductID prodID) { this.prodID = prodID; }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) { this.price = price; }


}
