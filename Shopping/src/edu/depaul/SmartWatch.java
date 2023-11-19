package edu.depaul;

public class SmartWatch implements Product {
    private double price = 150.0; // Example price for a smartwatch

    @Override
    public void displayInfo() {
        System.out.println("SmartWatch: Stylish smartwatch with health and fitness tracking features. Price: $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}