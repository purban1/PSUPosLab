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

    public final void customerNewSale(String custID){
        // Validate the String
        receipt.setupTheCustomer(custID);
    }

    // Cash register will talk to the database to send the product to a lineItem
    // maybe wise to insert this in the Product class 
    ProductCustomerDatabase productDatabase = new ProductCustomerDatabase(); 
    
    // When adding an item to a sale you need to look up the item in the database
    // Here we use the prodId to find product in the above array
    public final void addItemToSale(String prodId, int qty) {
        // Validate that the String before passing to productDatabase
        // Validate that the qty is not 0 or less
        Product product = null;
        // Lookup a product
        product = productDatabase.findTheProductInTheDatabse(prodId);

        // if found, add the lineItem to the receipt
        if (product != null) {
            receipt.addLineItem(product, qty);
        }

    }
    // Setyp the customer

//    public final void setupTheCustomer(String id) {
//        // Validate that the String is not null
//        Customer cust = null;
//        for (Customer c : customers) {
//            if (id.equals(c.getId())) {
//                cust = c;
//                break;
//            }
//        }
//        // if found, add the lineItem to the receipt
//        if (cust != null) {
//            receipt.setTheCustomer(cust);
//        }
//    }

    public final void displayTheReceipt() {
        receipt.outputReceiptToConsole();
    }
}
