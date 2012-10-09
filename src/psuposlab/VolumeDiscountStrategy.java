package psuposlab;

/**
 * This discount returns the after Thanksgiving sale discount
 *
 * @author Patrick Urban
 */
public class VolumeDiscountStrategy implements DiscountStrategy {

    private Double discount;

    // Constructor
    public VolumeDiscountStrategy(Double discountPercentage) {
        // Needs Validation
        this.discount = discountPercentage;
    }

    public final void setDiscount(Double discountPercentage) {
        // Needs Validation
        this.discount = discountPercentage;
    }

    @Override
    public final Double getDiscount(Double price, int qty) {
        if (qty >= 5) {
            return price * qty * this.discount;
        } else {
            return 0.0;
        }
    }
}
