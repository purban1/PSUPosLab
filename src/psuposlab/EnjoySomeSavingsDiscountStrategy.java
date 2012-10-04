package psuposlab;

/**
 * This discount returns a normal sale discount
 * @author Patrick Urban
 */
public class EnjoySomeSavingsDiscountStrategy implements DiscountStrategy{
    private final Double DISCOUNT = 0.1;
    
    @Override
    public Double getDiscount(Double price, int qty) {
        
        return price * qty * DISCOUNT;
    }
    
}
