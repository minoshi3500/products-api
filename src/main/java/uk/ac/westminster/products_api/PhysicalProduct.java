package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product{

    private double weightKg;
    private String dimensions;

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
}
