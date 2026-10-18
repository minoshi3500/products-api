package uk.ac.westminster.products_api;

public class Customer {

    private static int customerCount = 0;

    private Long id;
    private String name;
    private String email;
    private Address address;

    public Customer(Long id, String name, String email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        customerCount++;
    }

    private String[] tags;

    public String[] getTags() {
        return tags;
    }
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Address getAddress() {
        return address;
    }

    public static int getCustomerCount() {
        return customerCount;
    }
}
