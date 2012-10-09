package psuposlab;

/**
 * This class holds the ID, Description, price and applicable Discount for each
 * product.
 *
 * @author Patrick Urban
 */
public class Product {

    private String id;
    private String description;
    private double price;
    private DiscountStrategy discount;
    
    public Product(String id, String description, double price,
            DiscountStrategy discount) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    
    // Retrieves the amount of the Discount to a LineItem call
    public final double getDiscountfromSale(int qty){
        // verify that qty is not 0 or less
        return this.discount.getDiscount(price, qty);
    }
    
    public final DiscountStrategy getDiscountStrategy() {
        return discount;
    }

    public final void setDiscountStrategy(DiscountStrategy discount) {
        // Add verifier to make sure discount is a DiscountStrategy
        this.discount = discount;
    }

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        // Add verifier to make sure the String is not Null or blank
        this.id = id;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        // Add verifier to make sure the String is not Null or blank
        this.description = description;
    }

    public final double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        // verify that price is not 0 
        this.price = price;
    }

}
