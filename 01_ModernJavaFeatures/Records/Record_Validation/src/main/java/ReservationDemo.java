import java.time.LocalDate;

public class ReservationDemo {

    public static void main(String[] args) {
        Reservation reservation = new Reservation("Alice Johnson", LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 5), 214);
        System.out.println(reservation);
        System.out.println("Nights: " + reservation.nights());

        Object obj = reservation;
        if (obj instanceof Reservation) {
            Reservation r = (Reservation) obj;
            String guestName = r.guestName();
            LocalDate checkIn = r.checkIn();
            LocalDate checkOut = r.checkOut();
            int roomNumber = r.roomNumber();
            System.out.println(guestName + " stays in room " + roomNumber + " from " + checkIn + " to " + checkOut);
        }

        try {
            new Reservation("", LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 5), 214);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation works: " + e.getMessage());
        }

        try {
            new Reservation("Bob Smith", LocalDate.of(2024, 6, 5), LocalDate.of(2024, 6, 1), 101);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation works: " + e.getMessage());
        }
    }
}
