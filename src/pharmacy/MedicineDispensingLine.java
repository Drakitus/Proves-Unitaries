package pharmacy;

public class MedicineDispensingLine {

    private boolean acquired;
    ProductSaleLine productID;

    public MedicineDispensingLine(ProductSaleLine productID, boolean acquired){
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
