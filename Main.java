import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Product;
import payment.CardPayment;
import payment.Payment;
import payment.UpiPayment;
import service.CartService;
import service.PaymentService;

public class Main {
    @SuppressWarnings("FieldMayBeFinal")
    private static List<Product> products = new ArrayList<>();
    @SuppressWarnings("FieldMayBeFinal")
    private static CartService cartService = new CartService();
    @SuppressWarnings("FieldMayBeFinal")
    private static PaymentService paymentService = new PaymentService();
    @SuppressWarnings("FieldMayBeFinal")
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeProducts();
        
        System.out.println("========================================");
        System.out.println("   WELCOME TO SHOPPING CART SYSTEM");
        System.out.println("========================================\n");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> viewProducts();
                case 2 -> addToCart();
                case 3 -> removeFromCart();
                case 4 -> cartService.viewCart();
                case 5 -> checkout();
                case 6 -> {
                    System.out.println("\nThank you for shopping with us!");
                    running = false;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void initializeProducts() {
        products.add(new Product(1, "Laptop", 899.99, "Electronics"));
        products.add(new Product(2, "Smartphone", 599.99, "Electronics"));
        products.add(new Product(3, "Headphones", 79.99, "Electronics"));
        products.add(new Product(4, "Coffee Maker", 49.99, "Appliances"));
        products.add(new Product(5, "Backpack", 39.99, "Accessories"));
        products.add(new Product(6, "Water Bottle", 15.99, "Accessories"));
        products.add(new Product(7, "Desk Lamp", 29.99, "Home"));
        products.add(new Product(8, "Notebook", 5.99, "Stationery"));
    }

    private static void displayMenu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. View Products");
        System.out.println("2. Add to Cart");
        System.out.println("3. Remove from Cart");
        System.out.println("4. View Cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.println("==========================");
    }

    private static void viewProducts() {
        System.out.println("\n========== AVAILABLE PRODUCTS ==========");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("========================================");
    }

    private static void addToCart() {
        viewProducts();
        int productId = getIntInput("\nEnter Product ID to add: ");
        Product product = findProductById(productId);

        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        int quantity = getIntInput("Enter quantity: ");
        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
            return;
        }

        cartService.addToCart(product, quantity);
    }

    private static void removeFromCart() {
        cartService.viewCart();
        if (cartService.isEmpty()) {
            return;
        }

        int productId = getIntInput("\nEnter Product ID to remove: ");
        cartService.removeFromCart(productId);
    }

    private static void checkout() {
        if (cartService.isEmpty()) {
            System.out.println("Your cart is empty! Add items before checkout.");
            return;
        }

        cartService.viewCart();
        double total = cartService.calculateTotal();

        System.out.println("\n========== PAYMENT OPTIONS ==========");
        System.out.println("1. UPI Payment");
        System.out.println("2. Card Payment");
        System.out.println("3. Cancel");
        System.out.println("=====================================");

        int choice = getIntInput("Select payment method: ");
        Payment payment;

        switch (choice) {
            case 1 -> {
                System.out.print("Enter UPI ID: ");
                String upiId = scanner.nextLine();
                payment = new UpiPayment(upiId);
            }
            case 2 -> {
                System.out.print("Enter Card Number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Enter Card Holder Name: ");
                String cardHolder = scanner.nextLine();
                payment = new CardPayment(cardNumber, cardHolder);
            }
            case 3 -> {
                System.out.println("Checkout cancelled.");
                return;
            }
            default -> {
                System.out.println("Invalid payment method!");
                return;
            }
        }

        if (paymentService.processPayment(payment, total)) {
            cartService.clearCart();
            System.out.println("\nOrder placed successfully!");
            System.out.println("Thank you for your purchase!");
        }
    }

    private static Product findProductById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Invalid input! " + prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
