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
    private double netGrandTotal = 0.0;
    
    public final void addLineItem(Product product, int qty) {
        // Verify that product is of the correct type and qty is not 0 or less
        LineItem item = new LineItem(product, qty);
        addToArray(item);
    }

    public final void setupTheCustomer(String id) {
        // Validate that the String is not null
        Customer cust = null;
        for (Customer c : customers) {
            if (id.equals(c.getId())) {
                cust = c;
                break;
            }
        }
        // if found, add the lineItem to the receipt
        if (cust != null) {
            this.customer = cust;
        }
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

    public final void outputReceiptToConsole() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("Sold to:");
        System.out.println(this.customer.getName() + "\n" + this.customer.getAddress());
        System.out.println("----------------------------------------------------------------------\n");
        System.out.println("ID    Description     Qty  Price      Total $   Discount   Discount $");
        for (LineItem line : lineItems) {
            System.out.println(line.getLineItemDetails());
            grandTotal += line.getTotalBeforeDiscount();
            netDiscountTotal += line.getDiscountAmount();
        }
        System.out.println("\nGrand Total of Purchase:  " + nf.format(grandTotal));
        System.out.println("Total of Discount:         " + nf.format(netDiscountTotal));
        System.out.println("Amount Due:               " + nf.format(grandTotal - netDiscountTotal));

    }
}
