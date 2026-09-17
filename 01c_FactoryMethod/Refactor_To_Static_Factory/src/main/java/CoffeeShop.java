public class CoffeeShop {

    interface Beverage {
        double price();
    }

    static class Espresso implements Beverage {
        private final int shots;

        public Espresso(int shots) {
            this.shots = shots;
        }

        public double price() {
            return 1.8 * shots;
        }
    }

    static class Latte implements Beverage {
        private final int shots;
        private final boolean oatMilk;

        public Latte(int shots, boolean oatMilk) {
            this.shots = shots;
            this.oatMilk = oatMilk;
        }

        public double price() {
            return 2.5 + 1.6 * shots + (oatMilk ? 0.5 : 0);
        }
    }

    public static void main(String[] args) {
        Beverage a = new Espresso(-1); // bug: negative shots silently accepted
        Beverage b = new Latte(2, true);
        System.out.printf("%.2f%n", a.price());
        System.out.printf("%.2f%n", b.price());
    }
}
