package lt.vcs.finalproject.repository;

import androidx.annotation.NonNull;

public class Ingredient {

    private String productManufacturer;
    private String productName;
    private double productWeight;

    public Ingredient(String productManufacturer, String productName, double productWeight) {
        this.productManufacturer = productManufacturer;
        this.productName = productName;
        this.productWeight = productWeight;
    }

    @NonNull
    @Override
    public String toString() {
        return productManufacturer + " " + productName + " " + "(" + productWeight + ")";
    }

}
