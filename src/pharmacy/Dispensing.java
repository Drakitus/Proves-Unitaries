package pharmacy;

import data.ProductID;
import pharmacy.Exceptions.DispensingNotAvailableException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Dispensing {

    private byte nOrder; // n. of order for this dispensing inside the treatment.
    private boolean isCompleted;
    private Date initDate, finalDate;
    private Date todayDate;
    List<MedicineDispensingLine> presc; //Medicines to dispense and control.

    public Dispensing(byte nOrder, Date initDate, Date finalDate) {
        this.nOrder = nOrder;
        this.isCompleted = false;
        this.presc = new ArrayList<>();
        this.todayDate = new Date();
        this.initDate = initDate;
        this.finalDate = finalDate;
    }

    public boolean dispensingEnabled() throws DispensingNotAvailableException {
        if (todayDate.after(initDate) && todayDate.before(finalDate)){
            throw new DispensingNotAvailableException("The dispensing period is not correct");
        }else {
            return true;
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

    public boolean getisAcquired(ProductID productID) {
        Iterator<MedicineDispensingLine> it = presc.iterator();
        while (it.hasNext()){
            MedicineDispensingLine medicineLine = it.next();
            if(medicineLine.getMedicine().equals(productID)){
                return medicineLine.isAcquired();
            }
        }
        return false;

    }

    public byte getnOrder() { return nOrder; }

    public void setnOrder(byte nOrder) { this.nOrder = nOrder; }

    public Date getTodayDate() { return todayDate; }

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
}