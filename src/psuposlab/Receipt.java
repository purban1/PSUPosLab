package psuposlab;

import java.text.NumberFormat;

/**
 * A receipt for all items that have been purchased. Each item purchased is
 * stored in a lineItem array and lineItem objects.
 *
 * @author Patrick Urban
 */
public class Receipt {

    private Customer customer;
    private LineItem[] lineItems = new LineItem[0];
    private double grandTotal = 0.0;
    private double netDiscountTotal = 0.0;
    // retreive from the "database"  
    ProductCustomerDatabase prodCustDatabase = new ProductCustomerDatabase();

    // Finds the customer in the 'database'
    public final void locateTheCustomer(String customerID) {
        // Validate that the String is not null
        Customer cust = null;
        cust = prodCustDatabase.findTheCustomerInTheDatabse(customerID);

        // if found, add the lineItem to the receipt
        if (cust != null) {
            this.customer = cust;
        }
    }

    public final void addLineItem(String product, int qty) {
        // Verify that product is of the correct type and qty is not 0 or less        
        LineItem item = new LineItem(product, qty);
        addToArray(item);
    }

    // Copy the array into a temporary array that is length+1 to add a new
    // lineItem to the array
    private void addToArray(LineItem item) {
        // verify that item is of the correct type
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    public final Customer getTheCustomerInformation() {
        return customer;
    }

    public final void outputReceipt(ReceiptOutputStrategy getCustomerReceipt) {
        ReceiptSummary rs = new ReceiptSummary();
        String output = rs.getStringOfTheReceipt(customer, lineItems);
        getCustomerReceipt.ouputTheReceipt(output);
    }
    
}
