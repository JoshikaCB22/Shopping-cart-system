package payment;

public class UpiPayment implements Payment {
    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paying $" + amount + " via UPI");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Payment processed through UPI gateway...");
        return true;
    }
}
