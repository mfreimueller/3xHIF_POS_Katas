public class ShippingCalculator {

    enum ShippingMethod {
        STANDARD, EXPRESS, OVERNIGHT
    }

    static double cost(ShippingMethod method, double weightKg) {
        switch (method) {
            case STANDARD:
                return 2.0 + weightKg * 0.5;
            case EXPRESS:
                return 5.0 + weightKg * 0.8;
            case OVERNIGHT:
                return 12.0 + weightKg * 1.2;
            default:
                throw new IllegalStateException();
        }
    }

    static int estimatedDays(ShippingMethod method) {
        switch (method) {
            case STANDARD:
                return 5;
            case EXPRESS:
                return 2;
            case OVERNIGHT:
                return 1;
            default:
                throw new IllegalStateException();
        }
    }

    public static void main(String[] args) {
        for (ShippingMethod m : ShippingMethod.values()) {
            System.out.printf("%s: cost=%.2f, days=%d%n", m, cost(m, 3.0), estimatedDays(m));
        }
    }
}
