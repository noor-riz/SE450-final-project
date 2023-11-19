package edu.depaul;

import java.util.HashMap;
import java.util.Map;
class Account {
    private String accountName;
    private double balance;
    private Map<String, Integer> cartItems;

    public Account(String accountName) {
        this.accountName = accountName;
        this.balance = 20000.0; // Default balance
        this.cartItems = new HashMap<>();
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Map<String, Integer> getCartItems() {
        return cartItems;
    }

    public void addItemToCart(String product, int quantity) {
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
    }

    public void removeItemFromCart(String product, int quantity) {
        if (cartItems.containsKey(product)) {
            int currentQuantity = cartItems.get(product);
            if (quantity >= currentQuantity) {
                cartItems.remove(product);
            } else {
                cartItems.put(product, currentQuantity - quantity);
            }
        }
    }
}