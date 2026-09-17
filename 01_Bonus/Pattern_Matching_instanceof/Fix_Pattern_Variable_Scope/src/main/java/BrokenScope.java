import java.util.List;

public class BrokenScope {

    record Discount(String code, double percent) {}

    // Does not compile: `discount` is only definitely assigned when the
    // condition is true, but it is used after the `if` block, unconditionally.
    static String describe(Object voucher) {
        if (voucher instanceof Discount discount) {
            System.out.println("Applying voucher " + discount.code());
        }
        return discount.code() + " (" + discount.percent() + "%)";
    }

    // Does not compile: the condition is negated but the method does not
    // return/throw on the true branch, so `discount` is not definitely
    // assigned by the time it is printed.
    static void printIfDiscount(Object voucher) {
        if (!(voucher instanceof Discount discount)) {
            System.out.println("Not a discount: " + voucher);
        }
        System.out.println("Discount code: " + discount.code());
    }

    public static void main(String[] args) {
        List<Object> vouchers = List.of(new Discount("SAVE10", 10.0), "not a voucher");
        for (Object voucher : vouchers) {
            System.out.println(describe(voucher));
        }
        printIfDiscount(new Discount("WELCOME5", 5.0));
    }
}
