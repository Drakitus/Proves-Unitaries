package pharmacy;

import data.ProductID;

import java.math.BigDecimal;

public class ProductSpecification {
    ProductID UPCcode;
    String description;
    BigDecimal price;

    public ProductSpecification(ProductID UPCcode, String description, BigDecimal price) {
        this.UPCcode = UPCcode;
        this.description = description;
        this.price = price;
    }

    public String getDescription(){
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }


}
