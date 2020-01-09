package pharmacy;

import data.ProductID;

public class MedicineDispensingLine {

    private boolean acquired;
    private ProductID productID;


    public MedicineDispensingLine(ProductID productID, boolean acquired){
        this.acquired = acquired;
        this.productID = productID;
    }

    public boolean isAcquired() {
        return acquired;
    }

    public void setAcquired(ProductID productID) {
        this.acquired = true;
    }

    public ProductID getMedicine(){
        return productID; // id medicament
    }
}
