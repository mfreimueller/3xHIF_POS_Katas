public class PricedDemo {

    public static void main(String[] args) {
        Priced.Book book = new Priced.Book("Effective Java", 45.0);
        Priced.TrainTicket ticket = new Priced.TrainTicket("Vienna-Graz", 39.9);
        Priced.GymMembership membership = new Priced.GymMembership("Annual", 480.0);

        System.out.println(book.formatPrice() + " -> " + book.discountedPrice(0.1));
        System.out.println(ticket.formatPrice() + " -> " + ticket.discountedPrice(0.2));
        System.out.println(membership.formatPrice() + " -> " + membership.discountedPrice(0.25));
    }
}
