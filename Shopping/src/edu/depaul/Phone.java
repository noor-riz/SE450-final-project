package edu.depaul;

public class Phone implements Product {
    private double price = 500.0; // Example price for a phone

    @Override
    public void displayInfo() {
        System.out.println("Phone: Latest smartphone with amazing camera and battery life. Price: $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}