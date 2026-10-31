package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    @Override
    public void applyDiscount(double rate) {
        //shipping is never discounted, so cap reduction at 20!
        double capped = Math.min(rate, 0.20);
        discountedPrice = getPrice() * (1 - capped);
    }


    @Override
    public String getSummary() {
        return "Physical Product: " + getName()
                + " | Price: " + getPrice()
                + " | Weight: " + weightKg + "kg";
    }

    // No-arg constructor
    public PhysicalProduct(){
    }

    //Full constructor
    public PhysicalProduct(Long id,
                           String name,
                           double price,
                           double weightKg,
                           String dimensions){
        super (id, name, price);

        this.weightKg = weightKg;
        this.dimensions = dimensions;
        this.discountedPrice = price;
    }
    public double getWeightKg() {
        return weightKg;
    }
    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }
    public String getDimensions() {
        return dimensions;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
