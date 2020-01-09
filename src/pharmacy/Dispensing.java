package pharmacy;

import data.ProductID;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dispensing {

    private byte nOrder; // n. of order for this dispensing inside the treatment.
    private Date initDate, finalDate; // The period.
    private boolean isCompleted;
    private Date todayDate;
    List<MedicineDispensingLine> presc; //Medicines to dispense and control.

    public Dispensing() {
        this.todayDate = new Date();
        this.isCompleted = false;
        this.presc = new ArrayList<>();
    }
    public boolean dispensingEnabled() throws DispensingNotAvailableException{
        if (todayDate.after(initDate) && todayDate.before(finalDate)){
            return true;
        }else {
            throw new DispensingNotAvailableException("The dispensing period is not correct");
        }
    }
    public void setProductAsDispensed(ProductID prodID) {
        for (MedicineDispensingLine medicineLine : presc){
            if(medicineLine.getMedicine().equals(prodID)){
                medicineLine.setAcquired(prodID);
            }
        }
    }

    public boolean isCompleted() { return isCompleted; }

    public void setCompleted() { this.isCompleted = true; }

    public byte getnOrder() { return nOrder; }

    public void setnOrder(byte nOrder) { this.nOrder = nOrder; }

    public Date getInitDate() { return initDate; }

    public void setInitDate(Date initDate) { this.initDate = initDate; }

    public Date getFinalDate() { return finalDate; }

    public void setFinalDate(Date finalDate) { this.finalDate = finalDate; }

    public Date getTodayDate() { return todayDate; }

    public void setTodayDate(Date todayDate) { this.todayDate = todayDate; }

    public List<MedicineDispensingLine> getPresc() { return presc; }

    public void setPresc(List<MedicineDispensingLine> presc) { this.presc = presc; }

  // the rest of getters and setters ???
}
