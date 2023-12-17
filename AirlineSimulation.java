import java.util.Scanner;

// Abstract class representing an Aircraft
abstract class Aircraft {
    private String airline;
    private String model;
    private int capacity;

    // Constructor for Aircraft
    Aircraft(String airline, String model, int capacity) {
        this.airline = airline;
        this.model = model;
        this.capacity = capacity;
    }

    // Abstract method to perform specific operations for each Aircraft
    public abstract void performOperation();

    // Method to display general information about the Aircraft
    public void displayAircraftInfo() {
        System.out.println("\nAirline: " + airline);
        System.out.println("Model: " + model);
        System.out.println("Capacity: " + capacity + " passengers");
    }
}

// Concrete class representing an Airplane, a type of Aircraft
class Airplane extends Aircraft {
    private String aircraftType;

    // Constructor for Airplane
    Airplane(String airline, String model, int capacity, String aircraftType) {
        super(airline, model, capacity);
        this.aircraftType = aircraftType;
    }

    // Implementation of the performOperation method for Airplane
    @Override
    public void performOperation() {
        System.out.println("Aircraft Type: " + aircraftType);
    }
}

// Thread class for running the simulation of a flight
class FlightThread extends Thread {
    private Aircraft aircraft;

    // Constructor for FlightThread
    FlightThread(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    // Run method for the thread
    @Override
    public void run() {
        System.out.println("Flight Information:");
        aircraft.displayAircraftInfo();
        aircraft.performOperation();
    }
}

// Main class for the AirlineSimulation program
public class AirlineSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Airplane Details:");
        System.out.print("Airline: ");
        String airline = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Aircraft Type: ");
        String aircraftType = scanner.nextLine();

        // Create an instance of Airplane with user-entered details
        Airplane airplane = new Airplane(airline, model, capacity, aircraftType);
        // Create a FlightThread with the Airplane instance
        FlightThread flightThread = new FlightThread(airplane);

        System.out.println("\nEnter another Airplane Details:");
        // Similar input process for another airplane, you can extend the program accordingly

        // Start the FlightThread
        flightThread.start();

        try {
            // Wait for the FlightThread to finish before proceeding
            flightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
