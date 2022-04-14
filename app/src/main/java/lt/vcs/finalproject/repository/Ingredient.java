package lt.vcs.finalproject.repository;

public class Ingredient {

    private String productManufacturer;
    private String productName;
    private double productWeight;

    public Ingredient(String productManufacturer, String productName, double productWeight) {
        this.productManufacturer = productManufacturer;
        this.productName = productName;
        this.productWeight = productWeight;
    }

    @Override
    public String toString() {
        return productManufacturer + " " + productName + " (" + productWeight + ")";
    }

}
