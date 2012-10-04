package psuposlab;

/**
 * This discount returns no discount
 * @author Patrick Urban
 */
public class EnjoySomeSavingsDiscountStrategy implements DiscountStrategy{
    private final Double DISCOUNT = 0.1;
    
    @Override
    public Double getDiscount(Double price, int qty) {
        
        return price * qty * DISCOUNT;
    }
    
}
