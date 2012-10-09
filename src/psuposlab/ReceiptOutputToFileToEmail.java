package psuposlab;

/**
 * This class outputs to the Receipt to a PDF to be inserted as an 
 * email attachment.
 * 
 * @author Patrick Urban
 */
public class ReceiptOutputToFileToEmail implements ReceiptOutputStrategy{

    private double grandTotal = 0.0;
    private double netDiscountTotal = 0.0;
    
    @Override
    public void ouputTheReceipt(String receipt) {
        // Code here to send PDF output of the receipt for email purposes 
        

    }
    
}
