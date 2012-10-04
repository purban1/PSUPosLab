package psuposlab;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Description: This class contains the objects and field for a sale item
 *
 * @author Patrick Urban
 */
public class LineItem {

    private int quantity;
    private Product product;

    public LineItem(Product product, int qty) {
        // verify the type and that qty is not 0 or less
        this.quantity = qty;
        this.product = product;
    }

    // Summarize the contents of the LineItem object
    public final String getLineItemDetails() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        // Discount is not determined until here in case a price would
        // be reset
        double discount = getProduct().getDiscountfromSale(getQuantity());

        String theTally = "";
        theTally += product.getId() + "  ";
        theTally += product.getDescription() + "   ";
        theTally += this.getQuantity() + "   ";
        theTally += nf.format(product.getPrice()) + "     ";
        theTally += nf.format(getTotalBeforeDiscount()) + "   ";
        theTally += nf.format(discount) + "     ";
        theTally += nf.format(getTotalBeforeDiscount() - discount);

        return theTally;
    }

    /**
     * @return the quantity
     */
    private final int getQuantity() {
        return quantity;
    }

    /**
     * @return the product
     */
    private final Product getProduct() {
        return product;
    }
    
    public final double getTotalBeforeDiscount(){
        return quantity * product.getPrice();
    }
   
    public final double getDiscountAmount(){
        return getProduct().getDiscountfromSale(this.getQuantity());
    }

}
