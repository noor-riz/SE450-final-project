package edu.depaul;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


// Singleton pattern for shopping cart
public class ShoppingCart {
    private static ShoppingCart instance;
    private Map<String, Integer> cartItems;
    private String currentUser;
    private double userBalance = 20000.0;

    private ShoppingCart() {
        cartItems = new HashMap<>();
        currentUser = null;
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void login(String accountName) {
        currentUser = accountName;
        System.out.println("Welcome, " + accountName + "!");
        Logger.log("User logged in: " + accountName);
    }

    public void logout() {
        System.out.println("Goodbye, " + currentUser + "!");
        currentUser = null;
        Logger.log("User logged out: " + currentUser);
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public void addItem(String product, int quantity) {
        if (isLoggedIn()) {
            cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
            System.out.println(quantity + " " + product + "(s) added to the cart.");
            Logger.log("Item added to cart: " + quantity + " " + product + "(s)");
        } else {
            System.out.println("Please log in before adding items to the cart.");
        }
    }

    public void removeItem(String product, int quantity) {
        if (isLoggedIn()) {
            if (cartItems.containsKey(product)) {
                int currentQuantity = cartItems.get(product);
                if (quantity >= currentQuantity) {
                    cartItems.remove(product);
                } else {
                    cartItems.put(product, currentQuantity - quantity);
                }
                System.out.println(quantity + " " + product + "(s) removed from the cart.");
                Logger.log("Item removed from cart: " + quantity + " " + product + "(s)");
            } else {
                System.out.println("Product not found in the cart.");
            }
        } else {
            System.out.println("Please log in before removing items from the cart.");
        }
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("No items in the cart.");
        } else {
            System.out.println("Cart Contents:");
            for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

     public void processPayment() {
        if (isLoggedIn()) {
            if (cartItems.isEmpty()) {
                System.out.println("No items in the cart. Payment cannot be processed.");
            } else {
                double totalPrice = calculateTotalPrice();

                if (userBalance >= totalPrice) {
                    userBalance -= totalPrice;
                    System.out.println("Your Bill: $" + totalPrice);
                    Logger.log("Bill Generated: $" + totalPrice);
                    System.out.println("Payment successful! Remaining account balance: $" + userBalance);
                    Logger.log("Payment processed. Remaining balance: $" + userBalance);
                } else {
                    System.out.println("Insufficient funds. Payment failed.");
                }
            }
        } else {
            System.out.println("Please log in before processing payment.");
        }
    }

    public double getUserBalance() {
        return userBalance;
    }

    private double calculateTotalPrice() {
        double totalPrice = 0.0;

        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String productType = entry.getKey();
            int quantity = entry.getValue();

            Product product = ProductFactory.createProduct(productType);
            totalPrice += product.getPrice() * quantity;
        }

        return totalPrice;
    }
}
