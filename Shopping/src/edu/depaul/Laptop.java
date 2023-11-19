package edu.depaul;

// Update each product class to include the price
public class Laptop implements Product {
    private double price = 800.0; // Example price for a laptop

    @Override
    public void displayInfo() {
        System.out.println("Laptop: High-performance laptop with great features. Price: $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
