package psuposlab;

/**
 * This discount returns no discount
 * @author Patrick Urban
 */
public class DayAfterThanksgivingDiscountStrategy implements DiscountStrategy{
    private final Double DISCOUNT = 0.25;
    
    @Override
    public Double getDiscount(Double price, int qty) {
        
        return price * qty * DISCOUNT;
    }
    
}
