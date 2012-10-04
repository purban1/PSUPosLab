package psuposlab;

import java.text.NumberFormat;

/**
 * A receipt for all items that have been purchased.
 * @author Patrick Urban
 */
public class Receipt {

    private Customer customer;
    private LineItem[] lineItems = new LineItem[0];
    private double grandTotal=0.0;
    private double netDiscountTotal=0.0;
    private double netGrandTotal=0.0;
    
    public final void addLineItem(Product product, int qty) {
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
    
    public final void setTheCustomer(Customer c){
        // Verify that c is of type Customer
        this.customer=c;
    }
    
    public final Customer getTheCustomerInformation(){
        return customer;
    }
    
    public final void printTheReceipt(){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println(this.customer.getName() + "\n" + this.customer.getAddress());
        System.out.println("----------------------------------------------------------------------\n");
        System.out.println("ID    Description     Qty  Price      Total $   Discount  Discount $");
        for (LineItem line : lineItems){
            System.out.println(line.getLineItemDetails());
            grandTotal += line.getTotalBeforeDiscount();
            netDiscountTotal += line.getDiscountAmount();
        }
        System.out.println("\nGrand Total of Purchase: " + nf.format(grandTotal));
        System.out.println("Total of Discount:        " + nf.format(netDiscountTotal));
        System.out.println("Amount Due:              " + nf.format(grandTotal-netDiscountTotal));
            
    }
}
