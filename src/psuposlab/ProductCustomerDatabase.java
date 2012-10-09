package psuposlab;

/**
 * "database" that stores customer and product information 
 * @author Patrick Urban
 */
public class ProductCustomerDatabase {

    //Initialize Discount Strategies
    public static DiscountStrategy noDiscount = new PercentageDiscountStrategy(0.0);
    public static DiscountStrategy normalDiscount = new PercentageDiscountStrategy(0.1);
    public static DiscountStrategy christmasDiscount =
            new PercentageDiscountStrategy(0.55);
    public static DiscountStrategy turkeyDiscount =
            new PercentageDiscountStrategy(0.25);
    public static DiscountStrategy quantityDiscount = new VolumeDiscountStrategy(0.15);
    // Product Database array
    private Product[] products = {
        new Product("W101", "Women's Blouse", 36.50, turkeyDiscount),
        new Product("M102", "Man's Slacks  ", 35.50, normalDiscount),
        new Product("W103", "Women's purse ", 28.75, christmasDiscount),
        new Product("M104", "Man's Wallet  ", 9.25, noDiscount),
        new Product("K101", "Kids shirt    ", 12.50, quantityDiscount),
        new Product("K102", "Kids shoes    ", 18.00, normalDiscount)
    };

    // Search the product Database
    public final Product findTheProductInTheDatabse(String prodId) {
        //Validate the String
        Product product = null;
        for (Product prodList : products) {
            if (prodId.equals(prodList.getId())) {
                product = prodList;
                break;
            }
        }
        return product;
    }
    // Customer array 'database'
    private Customer[] customers = {
        new Customer("C001", "Mary Smith", "2468 Cherry Tree Rd, Milwaukee, WI 53221"),
        new Customer("C002", "Greg Johnson", "1357 Bumpy Hill Lane, Waukesha, WI 53056"),
        new Customer("C003", "Bill Chill", "5122 South 8th St, Delfield, WI 53298"),
        new Customer("C004", "Jill Martin", "W123 N456 Lilly Rd, Ixonia, WI 53055")};

    // Search the customer Database
    public final Customer findTheCustomerInTheDatabse(String custId) {
        //Validate the String
        Customer cust = null;
        for (Customer c : customers) {
            if (custId.equals(c.getId())) {
                cust = c;
                break;
            }
        }
        return cust;
    }
}
