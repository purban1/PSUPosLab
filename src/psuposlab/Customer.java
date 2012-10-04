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
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getAddress() {
        return addresss;
    }

    public final void setAddress(String address) {
        this.addresss = address;
    }
}
