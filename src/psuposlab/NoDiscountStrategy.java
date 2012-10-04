package psuposlab;

/**
 * This discount returns no discount
 * @author Patrick Urban
 */
public class NoDiscountStrategy implements DiscountStrategy{
    private final Double DISCOUNT = 0.0;
    
    @Override
    public Double getDiscount(Double price, int qty) {
        return DISCOUNT;
    }
    
}
