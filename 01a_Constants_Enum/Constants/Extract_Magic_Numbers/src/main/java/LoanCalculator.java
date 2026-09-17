public class LoanCalculator {

    static double monthlyPayment(double principal, int months) {
        double rate = 0.045 / 12;
        if (months > 360) {
            throw new IllegalArgumentException("Term too long");
        }
        double factor = Math.pow(1 + rate, -months);
        return principal * rate / (1 - factor);
    }

    static String classify(double principal) {
        if (principal > 500000) {
            return "JUMBO";
        } else if (principal < 1000) {
            return "REJECTED";
        }
        return "STANDARD";
    }

    public static void main(String[] args) {
        System.out.printf("Payment: %.2f%n", monthlyPayment(250000, 180));
        System.out.println("Classification: " + classify(600000));
        System.out.println("Classification: " + classify(500));
        System.out.println("Classification: " + classify(50000));
    }
}
