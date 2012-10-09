package psuposlab;

/**
 * This discount returns the Discount at after Christmas sales
 * @author Patrick Urban
 */
public class PercentageDiscountStrategy implements DiscountStrategy{
    private Double discount;
    
    // Constructor
    public  PercentageDiscountStrategy(Double discountPercentage){
        // Needs Validation
        this.discount = discountPercentage;
    }
    
    @Override
    public final Double getDiscount(Double price, int qty) {
        return price * qty * getDiscount();
    }

    /**
     * @return the discount
     */
    public final Double getDiscount() {
        return discount;
    }

    /**
     * @param discountPercentage the discount to set
     */
    public final void setDiscount(Double discountPercentage) {
        // Needs Validation
        this.discount = discountPercentage;
    }
    
}
