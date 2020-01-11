package pharmacy;

import data.ProductID;
import pharmacy.Exceptions.DispensingNotAvailableException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dispensing {

    private byte nOrder; // n. of order for this dispensing inside the treatment.
    private Date initDate, finalDate; // The period.
    private boolean isCompleted;
    List<MedicineDispensingLine> presc; //Medicines to dispense and control.

    public Dispensing() {
        this.isCompleted = false;
        this.presc = new ArrayList<>();
    }
    public boolean dispensingEnabled() throws DispensingNotAvailableException {
        Date todayDate = new Date();
        if (todayDate.after(initDate)){
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

    public List<MedicineDispensingLine> getPresc() { return presc; }

    public void setPresc(List<MedicineDispensingLine> presc) { this.presc = presc; }

    public void addLine(MedicineDispensingLine line){
        presc.add(line);
    }
    public MedicineDispensingLine getLine(ProductID productID){
        for(MedicineDispensingLine line : presc){
            if(line.getMedicine().equals(productID)){
                return line;
            }
        }
        return null;
    }

  // the rest of getters and setters ???
}
