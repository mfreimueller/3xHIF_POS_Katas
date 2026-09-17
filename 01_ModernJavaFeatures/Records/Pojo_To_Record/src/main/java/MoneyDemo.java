public class MoneyDemo {

    public static void main(String[] args) {
        Money price = new Money(1999, "EUR");
        Money shipping = new Money(500, "EUR");
        Money total = price.add(shipping);

        System.out.println("Total: " + total);
        System.out.println("Amount in cents: " + total.getAmountInCents());
        System.out.println("Currency: " + total.getCurrency());

        Money sameTotal = new Money(2499, "EUR");
        System.out.println("Equal totals: " + total.equals(sameTotal));

        try {
            new Money(-100, "EUR");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation works: " + e.getMessage());
        }
    }
}
