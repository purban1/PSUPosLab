package psuposlab;

import java.text.NumberFormat;

/**
 * This class returns a string that is a summary of the receipt containing the
 * customer name and address along with all items purchased.
 *
 * @author Patrick Urban
 */
public class ReceiptSummary {

    private String receiptString;
    private double grandTotal = 0.0;
    private double netDiscountTotal = 0.0;

    public final String getStringOfTheReceipt(Customer c, LineItem[] lItem) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        Customer customer = c;
        receiptString = "Sold to:\n";
        receiptString += customer.getName() + "\n" + customer.getAddress() + "\n";
        receiptString += "----------------------------------------------------------------------\n";
        receiptString += "ID    Description     Qty  Price      Total $   Discount   Discount $\n";
        for (LineItem line : lItem) {
            receiptString += line.getLineItemDetails() + "\n";
            grandTotal += line.getTotalBeforeDiscount();
            netDiscountTotal += line.getDiscountAmount();
        }
        receiptString += "\nGrand Total of Purchase:  " + nf.format(grandTotal);
        receiptString += "\nTotal of Discount:         " + nf.format(netDiscountTotal);
        receiptString += "\nAmount Due:               " + nf.format(grandTotal - netDiscountTotal);

        return receiptString;
    }
}
