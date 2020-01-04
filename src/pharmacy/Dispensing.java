package pharmacy;

import data.ProductID;

import java.util.Date;

public class Dispensing {

    private byte nOrder; // n. of order for this dispensing inside the treatment
    private Date initDate, finalDate; // The period
    private boolean isCompleted;

    private Date todayDate;
    MedicineDispensingLine mdl;
  // The set of medicines to dispense and its control, among others ???

    public Dispensing(Date initDate, Date finalDate) {
        this.initDate = initDate;
        this.finalDate = finalDate;
        this.todayDate = new Date();
        this.isCompleted = false;
    }
    public boolean dispensingEnabled() throws DispensingNotAvailableException{
        if (todayDate.after(initDate) && todayDate.before(finalDate)){
            return true;
        }else {
            throw new DispensingNotAvailableException("The dispensing period is not correct");
        }
    }
    public void setProductAsDispensed(ProductSaleLine prodID) {
        if (prodID == mdl.productID){
            mdl.setAcquired(true);
        }
    }

    public boolean isCompleted() { return isCompleted; }

    public void setCompleted(boolean isCompleted) { this.isCompleted = isCompleted; }

    public byte getnOrder() { return nOrder; }

    public void setnOrder(byte nOrder) { this.nOrder = nOrder; }
  // the rest of getters and setters ???
}
