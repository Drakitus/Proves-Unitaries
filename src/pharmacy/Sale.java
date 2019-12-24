package pharmacy;

import data.PatientContr;
import data.ProductID;

import java.math.BigDecimal;
import java.util.Date;

public class Sale {

    private int saleCode;
    private Date date;
    private BigDecimal amount;
    private boolean isClosed; // flag to know if the sale is closed

    // Its components, among others

    public Sale () { } // Assigns the current date, a code to the sale, etc.
    public void addLine(ProductID prodID, BigDecimal price, PatientContr contr)
            throws SaleClosedException { }
    private void calculateAmount() {  }
    private void addTaxes() throws SaleClosedException {  }
    public void calculateFinalAmount() throws SaleClosedException {  }
    // public BigDecimal getAmount() {  }
    private void setClosed() {  }
     //public boolean isClosed() { }
}
