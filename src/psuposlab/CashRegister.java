package psuposlab;

/**
 * CashRegister talks to the "database" for the products for sale and the
 * customers that the store knows about. It has three jobs: Pass the sale to the
 * receipt, pass the customer shopping to the receipt and tell the receipt to
 * print.
 *
 * @author Patrick Urban
 */
public class CashRegister {

    // Create a new Receipt
    private Receipt receipt = new Receipt();

    public final void customerNewSale(String custID) {
        // Validate the String
        receipt.locateTheCustomer(custID);
    }
    
    public final void addItemToSale(String prodId, int qty) {
        // Validate that the String before passing to productDatabase
        // Validate that the qty is not 0 or less
        receipt.addLineItem(prodId, qty);
    }

    public final void displayTheReceipt(ReceiptOutputStrategy getCustomerReceipt) {
        receipt.outputReceipt(getCustomerReceipt);
    }
}
