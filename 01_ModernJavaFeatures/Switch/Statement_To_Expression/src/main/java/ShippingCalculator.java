public class ShippingCalculator {

    enum ShippingMethod {
        STANDARD, EXPRESS, OVERNIGHT, INTERNATIONAL_STANDARD, INTERNATIONAL_EXPRESS
    }

    public double calculateCost(ShippingMethod method, double weightInKg) {
        double cost;
        switch (method) {
            case STANDARD:
                cost = 4.99 + weightInKg * 0.5;
                break;
            case EXPRESS:
                cost = 9.99 + weightInKg * 0.75;
                break;
            case OVERNIGHT:
                cost = 19.99 + weightInKg * 1.0;
                break;
            case INTERNATIONAL_STANDARD:
            case INTERNATIONAL_EXPRESS:
                double surcharge = method == ShippingMethod.INTERNATIONAL_EXPRESS ? 15.0 : 0.0;
                cost = 24.99 + weightInKg * 2.0 + surcharge;
                break;
            default:
                throw new IllegalArgumentException("Unknown shipping method: " + method);
        }
        return cost;
    }

    public static void main(String[] args) {
        ShippingCalculator calculator = new ShippingCalculator();
        System.out.printf("Standard: %.2f%n", calculator.calculateCost(ShippingMethod.STANDARD, 3));
        System.out.printf("Express: %.2f%n", calculator.calculateCost(ShippingMethod.EXPRESS, 3));
        System.out.printf("Overnight: %.2f%n", calculator.calculateCost(ShippingMethod.OVERNIGHT, 3));
        System.out.printf("Intl standard: %.2f%n", calculator.calculateCost(ShippingMethod.INTERNATIONAL_STANDARD, 3));
        System.out.printf("Intl express: %.2f%n", calculator.calculateCost(ShippingMethod.INTERNATIONAL_EXPRESS, 3));
    }
}
