package service;

import model.Product;
import model.CartItem;
import java.util.ArrayList;
import java.util.List;

public class CartServices {
    private List<CartItem> cartItems;

    public CartServices() {
        this.cartItems = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("Updated quantity in cart!");
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
        System.out.println("Product added to cart!");
    }

    public void removeFromCart(int productId) {
        cartItems.removeIf(item -> item.getProduct().getId() == productId);
        System.out.println("Product removed from cart!");
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }
        
        System.out.println("\n========== YOUR CART ==========");
        for (CartItem item : cartItems) {
            System.out.println(item);
        }
        System.out.println("===============================");
        System.out.printf("Total Amount: $%.2f\n", calculateTotal());
    }

    public double calculateTotal() {
        return cartItems.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public void clearCart() {
        cartItems.clear();
    }
}
