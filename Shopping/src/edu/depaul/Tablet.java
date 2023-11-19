package edu.depaul;

public class Tablet implements Product {
    private double price = 300.0; // Example price for a tablet

    @Override
    public void displayInfo() {
        System.out.println("Tablet: Portable tablet with a sleek design and powerful functionality. Price: $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
