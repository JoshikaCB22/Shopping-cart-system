package payment;

public class CardPayment implements Payment {
    private String cardNumber;
    private String cardHolderName;

    public CardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = maskCardNumber(cardNumber);
        this.cardHolderName = cardHolderName;
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() > 4) {
            return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
        }
        return cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paying $" + amount + " via Card");
        System.out.println("Card: " + cardNumber);
        System.out.println("Holder: " + cardHolderName);
        System.out.println("Payment processed through card gateway...");
        return true;
    }
}
