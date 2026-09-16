public interface Priced {

    double price();

    record Book(String title, double price) implements Priced {
        public double discountedPrice(double rate) {
            if (rate < 0 || rate > 1) {
                throw new IllegalArgumentException("rate must be between 0 and 1");
            }
            return price() - (price() * rate);
        }

        public String formatPrice() {
            return String.format("EUR %.2f", price());
        }
    }

    record TrainTicket(String route, double price) implements Priced {
        public double discountedPrice(double rate) {
            if (rate < 0 || rate > 1) {
                throw new IllegalArgumentException("rate must be between 0 and 1");
            }
            return price() - (price() * rate);
        }

        public String formatPrice() {
            return String.format("EUR %.2f", price());
        }
    }

    record GymMembership(String plan, double price) implements Priced {
        public double discountedPrice(double rate) {
            if (rate < 0 || rate > 1) {
                throw new IllegalArgumentException("rate must be between 0 and 1");
            }
            return price() - (price() * rate);
        }

        public String formatPrice() {
            return String.format("EUR %.2f", price());
        }
    }
}
