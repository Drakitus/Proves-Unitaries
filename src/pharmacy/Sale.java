package pharmacy;

import data.Exceptions.PatientContrException;
import data.PatientContr;
import data.ProductID;
import pharmacy.Exceptions.SaleClosedException;

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

    private ProductSaleLine psl;
    private Dispensing disp;

    public Sale (int saleCode) {
        this.saleCode = saleCode;
        this.date = new Date();
        this.amount = new BigDecimal(0);
        this.isClosed = false;
        this.partial = new ArrayList<>();
    } // Assigns the current date, a code to the sale, etc.

    public void addLine(ProductID prodID, BigDecimal price, PatientContr contr) throws SaleClosedException {
        if(isClosed){
            throw new SaleClosedException("The sale is closed");
        }
        psl = new ProductSaleLine(prodID,price,contr);
        partial.add(psl);
    }

    private void calculateAmount() throws PatientContrException {
        for(ProductSaleLine psl : partial){
            amount = amount.add(psl.getSubTotal());
        }
    }

    private void addTaxes() throws SaleClosedException {
        if(isClosed){
            throw new SaleClosedException("The sale is closed");
        }
        amount = amount.multiply(BigDecimal.valueOf(1.21));
    }

    public void calculateFinalAmount() throws SaleClosedException, PatientContrException {
        if (isClosed){
            throw new SaleClosedException("The sale is closed");
        }
        calculateAmount();
        addTaxes();
    }

    public BigDecimal getAmount() throws SaleClosedException, PatientContrException {
        calculateFinalAmount();
        return amount;
    }

    public boolean isClosed() { return isClosed; }

    public void setClosed(){ this.isClosed = true;}

    public Dispensing getDispensing(){ return disp;}

    public void setDispensing(Dispensing disp) { this.disp = disp; }

    public ProductSaleLine getProductSaleLine(){ return psl;}

}
