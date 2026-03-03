package service;

import payment.Payment;

public class PaymentService {
    
    public boolean processPayment(Payment payment, double amount) {
        System.out.println("\nProcessing payment...");
        boolean success = payment.pay(amount);
        
        if (success) {
            System.out.println("Payment successful!");
            return true;
        } else {
            System.out.println("Payment failed!");
            return false;
        }
    }
}
