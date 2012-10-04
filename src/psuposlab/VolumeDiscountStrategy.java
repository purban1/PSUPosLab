package psuposlab;

/**
 * This discount returns the after Thanksgiving sale discount
 *
 * @author Patrick Urban
 */
public class VolumeDiscountStrategy implements DiscountStrategy {

    private final Double DISCOUNT = 0.15;

    @Override
    public Double getDiscount(Double price, int qty) {
        if (qty >= 5) {
            return price * qty * DISCOUNT;
        } else {
            return 0.0;
        }
    }
}
