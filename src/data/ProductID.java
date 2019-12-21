package data;

import java.util.Objects;

final public class ProductID {

    private final String prodUPC;

    public ProductID(String prodUPC) {
        Objects.requireNonNull(prodUPC, "The productID cannot be NULL");

        if (prodUPC.isEmpty()) throw new IllegalArgumentException("ProductId cannot be EMPTY");
        if (prodUPC.isBlank()) throw new IllegalArgumentException("ProductID cannot be WhiteSpaces");
        if (!isValidHealthCardID(prodUPC)) throw new IllegalArgumentException("ProductID has to be a String of numbers");

        this.prodUPC = prodUPC;

    }
    private Boolean isValidHealthCardID(String prodUPC){return prodUPC.matches("[0-12]+");}
    public String getProdUPC() { return prodUPC; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductID party1 = (ProductID) o;
        return prodUPC.equals(party1.prodUPC);
    }
    @Override
    public int hashCode() { return prodUPC.hashCode(); }

    @Override
    public String toString() {
        return "ProductID{" + "product code='" + prodUPC + '\'' + '}';
    }
}
