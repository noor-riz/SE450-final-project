package edu.depaul;

// Builder pattern for cart construction
public class CartBuilder {
    private ShoppingCart cart;

    public CartBuilder() {
        this.cart = ShoppingCart.getInstance();
    }

    public CartBuilder addItem(String product, int quantity) {
        cart.addItem(product, quantity);
        return this;
    }

    public CartBuilder removeItem(String product, int quantity) {
        cart.removeItem(product, quantity);
        return this;
    }

    public void viewCart() {
        cart.viewCart();
    }

    public void processPayment() {
        cart.processPayment();
    }
}
