package edu.depaul;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class ShoppingCart {
    private static ShoppingCart instance;
    private Account currentUserAccount;

    private ShoppingCart() {
        // Singleton pattern constructor
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void login(String accountName) {
        if (AccountManager.getAccount(accountName) != null) {
            currentUserAccount = AccountManager.getAccount(accountName);
            System.out.println("Welcome back, " + accountName + "!");
            Logger.log("User logged in: " + accountName);
        } else {
            currentUserAccount = new Account(accountName);
            AccountManager.addAccount(accountName, currentUserAccount);
            System.out.println("Welcome, " + accountName + "!");
            Logger.log("User logged in: " + accountName);
        }
    }

    public void logout() {
        if (isLoggedIn()) {
            System.out.println("Goodbye, " + currentUserAccount.getAccountName() + "!");
            Logger.log("User logged out: " + currentUserAccount.getAccountName());
            AccountManager.addAccount(currentUserAccount.getAccountName(), currentUserAccount);
            currentUserAccount = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public boolean isLoggedIn() {
        return currentUserAccount != null;
    }

    public void addItem(String product, int quantity) {
        if (isLoggedIn()) {
            currentUserAccount.addItemToCart(product, quantity);
            Logger.log("Item added to cart: " + quantity + " " + product + "(s)");
        } else {
            System.out.println("Please log in before adding items to the cart.");
        }
    }

    public void removeItem(String product, int quantity) {
        if (isLoggedIn()) {
            currentUserAccount.removeItemFromCart(product, quantity);
            Logger.log("Item removed from cart: " + quantity + " " + product + "(s)");
        } else {
            System.out.println("Please log in before removing items from the cart.");
        }
    }

    public void viewCart() {
        if (isLoggedIn()) {
            Map<String, Integer> cartItems = currentUserAccount.getCartItems();
            if (cartItems.isEmpty()) {
                System.out.println("No items in the cart.");
            } else {
                System.out.println("Cart Contents:");
                for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        } else {
            System.out.println("Please log in to view the cart.");
        }
    }

    public void processPayment() {
        if (isLoggedIn()) {
            Map<String, Integer> cartItems = currentUserAccount.getCartItems();
            double totalPrice = calculateTotalPrice(cartItems);
    
            System.out.println("Total Price: $" + totalPrice);
    
            if (currentUserAccount.getBalance() >= totalPrice) {
                currentUserAccount.setBalance(currentUserAccount.getBalance() - totalPrice);
                Logger.log("Payment processed. Remaining balance for "
                        + currentUserAccount.getAccountName() + ": $" + currentUserAccount.getBalance());
                System.out.println("Payment successful!");
                System.out.println("Remaining balance: $" + currentUserAccount.getBalance());
            } else {
                Logger.log("Insufficient funds. Payment failed for "
                        + currentUserAccount.getAccountName() + ".");
                System.out.println("Payment failed. Insufficient funds. Current balance: $" + currentUserAccount.getBalance());
            }
    
            // Clear the cart after processing payment
            currentUserAccount.getCartItems().clear();
        } else {
            System.out.println("Please log in before processing payment.");
        }
    }
    
    // private double calculateTotalPrice(Map<String, Integer> cartItems) {
    //     double totalPrice = 0.0;

    //     for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
    //         String productType = entry.getKey();
    //         int quantity = entry.getValue();

    //         Product product = ProductFactory.createProduct(productType);
    //         totalPrice += product.getPrice() * quantity;
    //     }

    //     return totalPrice;
    // }

    private double calculateTotalPrice(Map<String, Integer> cartItems) {
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
