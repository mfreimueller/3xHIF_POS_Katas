import java.time.LocalDate;

public record Reservation(String guestName, LocalDate checkIn, LocalDate checkOut, int roomNumber) {
}
