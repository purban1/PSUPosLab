package psuposlab;

/**
 * Instantiates the CashRegister and passes the customer number
 * @author Patrick Urban
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // output strategy for the receipt
//        ReceiptOutputStrategy getCusReceipt = new ReceiptOutputToConsole();
        ReceiptOutputStrategy getCusReceipt = new ReceiptOutputToScreen();
        
        
        CashRegister cr = new CashRegister();

//        cr.setupTheCustomer("C003");
        cr.customerNewSale("C001");
        
        cr.addItemToSale("M102", 4);
        cr.addItemToSale("W101", 3);
        cr.addItemToSale("M104", 2);
        cr.addItemToSale("K101", 6);
        
                            
        cr.displayTheReceipt(getCusReceipt);
    }
}
