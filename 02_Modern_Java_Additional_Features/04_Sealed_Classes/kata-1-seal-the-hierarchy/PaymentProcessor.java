public class PaymentProcessor {

    interface PaymentMethod {}

    record CreditCard(String cardNumber, double amount) implements PaymentMethod {}

    record PayPal(String email, double amount) implements PaymentMethod {}

    record BankTransfer(String iban, double amount) implements PaymentMethod {}

    static double fee(PaymentMethod method) {
        return switch (method) {
            case CreditCard cc -> cc.amount() * 0.029;
            case PayPal pp -> pp.amount() * 0.034;
            case BankTransfer bt -> 0.35;
            default -> throw new IllegalStateException("Unknown payment method: " + method);
        };
    }

    public static void main(String[] args) {
        PaymentMethod[] methods = {
                new CreditCard("4111111111111111", 100.0),
                new PayPal("buyer@example.com", 50.0),
                new BankTransfer("AT611904300234573201", 200.0)
        };
        for (PaymentMethod method : methods) {
            System.out.printf("Fee: %.2f%n", fee(method));
        }
    }
}
