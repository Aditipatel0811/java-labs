import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AirlineSeat<T> {
    private T seatClass;
    private int seatNumber;
    private boolean isBooked;
    private String passengerName;

    public AirlineSeat(T seatClass, int seatNumber) {
        this.seatClass = seatClass;
        this.seatNumber = seatNumber;
        this.isBooked = false;
        this.passengerName = "";
    }

    public T getSeatClass() {
        return seatClass;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
}

interface Reservation<T> {
    void reserveSeat(T seat, String passengerName);
    void cancelReservation(T seat);
    void displayReservedSeats();
}

class FlightReservation<T> implements Reservation<T> {
    private List<T> reservedSeats;

    public FlightReservation() {
        this.reservedSeats = new ArrayList<>();
    }

    @Override
    public void reserveSeat(T seat, String passengerName) {
        if (!reservedSeats.contains(seat)) {
            reservedSeats.add(seat);
            ((AirlineSeat<?>) seat).setBooked(true);
            ((AirlineSeat<?>) seat).setPassengerName(passengerName);
            System.out.println("Seat " + ((AirlineSeat<?>) seat).getSeatNumber() + " reserved successfully!");
        } else {
            System.out.println("Seat " + ((AirlineSeat<?>) seat).getSeatNumber() + " is already reserved.");
        }
    }

    @Override
    public void cancelReservation(T seat) {
        if (reservedSeats.contains(seat)) {
            reservedSeats.remove(seat);
            ((AirlineSeat<?>) seat).setBooked(false);
            ((AirlineSeat<?>) seat).setPassengerName("");
            System.out.println("Reservation for Seat " + ((AirlineSeat<?>) seat).getSeatNumber() + " cancelled.");
        } else {
            System.out.println("Seat " + ((AirlineSeat<?>) seat).getSeatNumber() + " is not reserved.");
        }
    }

    @Override
    public void displayReservedSeats() {
        System.out.println("Reserved Seats:");
        for (T seat : reservedSeats) {
            System.out.println("Seat Number: " + ((AirlineSeat<?>) seat).getSeatNumber() +
                    ", Class: " + ((AirlineSeat<?>) seat).getSeatClass() +
                    ", Passenger: " + ((AirlineSeat<?>) seat).getPassengerName());
        }
    }
}

public class AirlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightReservation<AirlineSeat<?>> reservationSystem = new FlightReservation<>();

        while (true) {
            System.out.println("Welcome to Airline Reservation System");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Cancel reservation");
            System.out.println("3. Display reserved seats");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter seat number: ");
                    int seatNumber = scanner.nextInt();
                    System.out.print("Enter seat class: ");
                    scanner.nextLine(); // Consume newline
                    String seatClass = scanner.nextLine();
                    System.out.print("Enter passenger's name: ");
                    String passengerName = scanner.nextLine();

                    AirlineSeat<String> seat = new AirlineSeat<>(seatClass, seatNumber);
                    reservationSystem.reserveSeat(seat, passengerName);
                    break;

                case 2:
                    System.out.print("Enter seat number to cancel reservation: ");
                    int seatToCancel = scanner.nextInt();
                    AirlineSeat<String> seatCancel = new AirlineSeat<>("", seatToCancel);
                    reservationSystem.cancelReservation(seatCancel);
                    break;

                case 3:
                    reservationSystem.displayReservedSeats();
                    break;

                case 4:
                    System.out.println("Exiting Airline Reservation System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}