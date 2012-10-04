package psuposlab;

/**
 * Interface for all product discounts in the POS
 * @author Patrick Urban
 */
public interface DiscountStrategy {
    public abstract Double getDiscount(Double price, int qty);
}
