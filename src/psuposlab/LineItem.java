package psuposlab;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Description: This class contains the objects and field for a sale item. It
 * holds a product object containing the ID, description, price and the discount
 * strategy used for each product.
 *
 * @author Patrick Urban
 */
public class LineItem {

    private int quantity;
    private Product product;

    // Will find the product in the 'database'
    ProductCustomerDatabase productDatabase = new ProductCustomerDatabase(); 

    // Method will set the quantity and lookup the correct product in the
    // 'database' productDatabase
    public LineItem(String prodID, int qty) {
        // verify the type and that qty is not 0 or less
        this.quantity = qty;
        this.product = locateTheProduct(prodID);
    }

        
    // Finds the product in the 'database'
    public final Product locateTheProduct(String prodID) {
        // Validate that the String is not null
        Product product = null;
        product = productDatabase.findTheProductInTheDatabse(prodID);

        // if found, add the lineItem to the receipt
        if (product != null) {
            this.product = product;
        }
        return product;
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
    
    /**
     * @return the total of the purchase
     */
    public final double getTotalBeforeDiscount(){
        return quantity * product.getPrice();
    }
   
    /**
     * Passing the quantity to the product object method
     * @return the discount amount
     */
    public final double getDiscountAmount(){
        return this.getProduct().getDiscountfromSale(this.getQuantity());
    }

}
