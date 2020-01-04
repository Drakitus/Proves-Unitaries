package pharmacy;

import data.PatientContr;
import data.ProductID;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale {

    // Its components, among others
    private int saleCode;
    private Date date;
    private BigDecimal amount;
    private boolean isClosed; // flag to know if the sale is closed
    private List<ProductSaleLine> partial;

    public Sale (int saleCode, Date date) {
        this.saleCode = saleCode;
        this.date = date;
        this.amount = new BigDecimal(0);
        this.isClosed = false;
        this.partial = new ArrayList<>();
    } // Assigns the current date, a code to the sale, etc.

    public void addLine(ProductID prodID, BigDecimal price, PatientContr contr)throws SaleClosedException {
        if(isClosed){
            throw new SaleClosedException("The sale is closed");
        }
        ProductSaleLine psl = new ProductSaleLine(prodID,price,contr);
        partial.add(psl);
    }

    private void calculateAmount() {
        for(ProductSaleLine psl : partial){
            amount = amount.add(psl.getPrice());
        }
    }

    private void addTaxes() throws SaleClosedException {
        if(isClosed){
            throw new SaleClosedException("The sale is closed");
        }
        amount = amount.multiply(new BigDecimal(1.21));
    }

    public void calculateFinalAmount() throws SaleClosedException { //Review
        if (isClosed){
            throw new SaleClosedException("The sale is closed");
        }
        calculateAmount();
        addTaxes();
    }

    public int getSaleCode() { return saleCode; }

    public void setSaleCode(int saleCode) { this.saleCode = saleCode; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public BigDecimal getAmount() { return amount; }

    private void setClosed() { this.isClosed = true; }

    public boolean isClosed() { return isClosed; }

}
