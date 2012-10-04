package psuposlab;

/**
 * This class holds the ID, Name, and address for each
 * customer
 *
 * @author Patrick Urban
 */
public class Customer {

    private String id;
    private String name;
    private String addresss;

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.addresss = address;
    }

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        // Add verifier to make sure the String is not Null or blank
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        // Add verifier to make sure the String is not Null or blank
        this.name = name;
    }

    public final String getAddress() {
        return addresss;
    }

    public final void setAddress(String address) {
        // Add verifier to make sure the String is not Null or blank
        this.addresss = address;
    }
}
