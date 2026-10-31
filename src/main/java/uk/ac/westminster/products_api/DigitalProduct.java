package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable {

    private String downloadUrl;
    private double fileSizeMB;
    private double discountedPrice;

    @Override
    public void applyDiscount(double rate) {
        discountedPrice = getPrice() * (1-rate);
    }

    @Override
    public String getSummary() {
        return "Digital Product: " + getName()
                + " | Price: " + getPrice()
                + " | Download: " + downloadUrl;
    }

    // No-argument constructor
    public  DigitalProduct(){
    }

    //Full constructor
    public DigitalProduct(Long id,
                          String name,
                          double price,
                          String downloadUrl,
                          double fileSizeMB){
        super(id, name, price);

        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
        this.discountedPrice = price;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
    public double getFileSizeMB() {
        return fileSizeMB;
    }
    public void setFileSizeMB(double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
