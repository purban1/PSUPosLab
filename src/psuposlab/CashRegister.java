package psuposlab;

/**
 * CashRegister contains the "database" for the products for sale and the
 * customers that the store knows about. It has three jobs: Pass the sale to
 * the receipt, pass the customer shopping to the receipt and tell the receipt 
 * to print.
 * @author Patrick Urban
 */
public class CashRegister {

    private DiscountStrategy noDiscount = new NoDiscountStrategy();
    private DiscountStrategy normalDiscount = new EnjoySomeSavingsDiscountStrategy();
    private DiscountStrategy christmasDiscount =
            new DayAfterChristmasDiscountStrategy();
    private DiscountStrategy turkeyDiscount =
            new DayAfterThanksgivingDiscountStrategy();
    private Receipt receipt = new Receipt();
    
    private Product[] products = {
        new Product("W101", "Women's Blouse", 36.50, turkeyDiscount),
        new Product("M102", "Man's Slacks  ", 35.50, normalDiscount),
        new Product("W103", "Women's purse ", 28.75, christmasDiscount),
        new Product("M104", "Man's Wallet  ", 9.25, noDiscount),
        new Product("K101", "Kids shirt    ", 12.50, normalDiscount),
        new Product("K102", "Kids shoes    ", 18.00, normalDiscount)
    };
    
    private Customer[] customers = {
        new Customer("C001", "Mary Smith", "2468 Cherry Tree Rd, Milwaukee, WI 53221"),
        new Customer("C002", "Greg Johnson", "1357 Bumpy Hill Lane, Waukesha, WI 53056"),
        new Customer("C003", "Bill Chill", "5122 South 8th St, Delfield, WI 53298"),
        new Customer("C004", "Jill Martin", "W123 N456 Lilly Rd, Ixonia, WI 53055")};

    // When adding an item to a sale you need to look up the item in the database
    // Here we use the prodId to find product in the above array
    public void addItemToSale(String prodId, int qty) {
        // Validate that the String is not null and qty not 0 or less
        Product product = null;
        for (Product p : products) {
            if (prodId.equals(p.getId())) {
                product = p;
                break;
            }
        }
        // if found, add the lineItem to the receipt
        if (product != null) {
            receipt.addLineItem(product, qty);
        }

    }
    // Setyp the customer
    public final void setupTheCustomer(String id){
        // Validate that the String is not null
        Customer cust = null;
        for (Customer c : customers) {
            if (id.equals(c.getId())) {
                cust = c;
                break;
            }
        }
        // if found, add the lineItem to the receipt
        if (cust != null) {
            receipt.setTheCustomer(cust);
        }
    }

    public final void printTheReceipt() {
        receipt.printTheReceipt();
    }
}
