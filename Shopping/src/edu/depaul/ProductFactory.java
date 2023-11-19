package edu.depaul;

public class ProductFactory {
    public static Product createProduct(String type) {
        switch (type.toLowerCase()) {
            case "laptop":
                return new Laptop();
            case "phone":
                return new Phone();
            case "tablet":
                return new Tablet();
            case "smartwatch":
                return new SmartWatch();
            default:
                throw new IllegalArgumentException("Invalid product type.");
        }
    }
}