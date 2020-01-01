package pharmacy;

import data.ProductID;

public class MedicineDispensingLine {

    private boolean acquired;
    ProductID productID;

    public MedicineDispensingLine(ProductID productID, boolean acquired){
        this.acquired = acquired;
        this.productID = productID;
    }

    public boolean isAcquired() {
        return acquired;
    }

    public void setAcquired(boolean acquired) {
        this.acquired = acquired;
    }
}
