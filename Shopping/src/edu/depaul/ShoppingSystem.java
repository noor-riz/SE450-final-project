package edu.depaul;


import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



// Singleton pattern for shopping cart
public class ShoppingSystem {

    public static void viewProductOption(){
        System.out.println("Available Products:");
        Product laptop = ProductFactory.createProduct("laptop");
        Product phone = ProductFactory.createProduct("phone");
        Product tablet = ProductFactory.createProduct("tablet");
        Product smartWatch = ProductFactory.createProduct("smartwatch");

        laptop.displayInfo();
        phone.displayInfo();
        tablet.displayInfo();
        smartWatch.displayInfo();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Login");
            System.out.println("2. Logout");
            System.out.println("3. View Products");
            System.out.println("4. Add to Cart");
            System.out.println("5. Remove from Cart");
            System.out.println("6. View Cart");
            System.out.println("7. Process Payment");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your account name: ");
                    String accountName = scanner.next();
                    ShoppingCart.getInstance().login(accountName);
                    break;

                case 2:
                    ShoppingCart.getInstance().logout();
                    break;

                case 3:
                    viewProductOption();
                    break;

                case 4:
                    viewProductOption();
                    System.out.println();
                    if (ShoppingCart.getInstance().isLoggedIn()) {
                        System.out.print("Enter product type (laptop/phone/tablet/smartwatch): ");
                        String productType = scanner.next();
                        System.out.print("Enter quantity: ");
                        int quantityToAdd = scanner.nextInt();

                        CartBuilder cartBuilder = new CartBuilder();
                        cartBuilder.addItem(productType, quantityToAdd).viewCart();
                    } else {
                        System.out.println("Please log in before adding items to the cart.");
                    }
                    break;

                case 5:
                    if (ShoppingCart.getInstance().isLoggedIn()) {
                        System.out.print("Enter product type to remove (laptop/phone/tablet/smartwatch): ");
                        String productToRemove = scanner.next();
                        System.out.print("Enter quantity to remove: ");
                        int quantityToRemove = scanner.nextInt();

                        CartBuilder cartBuilderRemove = new CartBuilder();
                        cartBuilderRemove.removeItem(productToRemove, quantityToRemove).viewCart();
                    } else {
                        System.out.println("Please log in before removing items from the cart.");
                    }
                    break;

                case 6:
                    CartBuilder viewCartBuilder = new CartBuilder();
                    viewCartBuilder.viewCart();
                    break;

                case 7:
                    CartBuilder processPaymentBuilder = new CartBuilder();
                    processPaymentBuilder.processPayment();
                    break;

                case 8:
                    System.out.println("Exiting the shopping system. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
