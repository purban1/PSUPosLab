package psuposlab;

/**
 * This discount returns the Discount at after Christmas sales
 * @author Patrick Urban
 */
public class DayAfterChristmasDiscountStrategy implements DiscountStrategy{
    private final Double DISCOUNT = 0.55;
    
    @Override
    public Double getDiscount(Double price, int qty) {
        
        return price * qty * DISCOUNT;
    }
    
}
