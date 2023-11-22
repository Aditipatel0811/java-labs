class Aircraft {
    int fuelCapacity;
    void takeOff() {
        System.out.println("Taking off");
    }
    void land() {
        System.out.println("Landing");
    }
}
class PassengerPlane extends Aircraft {
    int passengerCapacity;
    void emergencyLanding() {
        System.out.println("Performing emergency landing");
        super.land(); 
    }
}
class CargoPlane extends Aircraft {
    double cargoCapacity;
    void loadCargo() {
        System.out.println("Loading cargo");
    }

    void unloadCargo() {
        System.out.println("Unloading cargo");
    }
}
abstract class Flight {
    
    abstract void checkIn();
    abstract void securityCheck();
    abstract void board();
}
class DomesticFlight extends Flight {
    
    void checkIn() {
        System.out.println("Checking in for domestic flight");
    }
    void securityCheck() {
        System.out.println("Passing security check for domestic flight");
    }
    void board() {
        System.out.println("Boarding for domestic flight");
    }
}
class InternationalFlight extends Flight {
    
    void checkIn() {
        System.out.println("Checking in for international flight");
    }
    void securityCheck() {
        System.out.println("Passing security check for international flight");
    }
    void board() {
        System.out.println("Boarding for international flight");
    }
}
final class Pilot {
    
    void pilotTasks() {
        System.out.println("Performing pilot tasks");
    }
}
class SpecialAircraft extends Aircraft {
    
    final void takeOff() {
        System.out.println("Taking off with special procedure");
    }
}
public class AirlineSystem {
    public static void main(String[] args) {
    
        PassengerPlane passengerPlane = new PassengerPlane();
        passengerPlane.takeOff();
        passengerPlane.emergencyLanding();

        CargoPlane cargoPlane = new CargoPlane();
        cargoPlane.land();
        cargoPlane.loadCargo();

        DomesticFlight domesticFlight = new DomesticFlight();
        domesticFlight.checkIn();
        domesticFlight.securityCheck();
        domesticFlight.board();

        InternationalFlight internationalFlight = new InternationalFlight();
        internationalFlight.checkIn();
        internationalFlight.securityCheck();
        internationalFlight.board();

        Pilot pilot = new Pilot();
        pilot.pilotTasks();

        SpecialAircraft specialAircraft = new SpecialAircraft();
        specialAircraft.takeOff();
    }
}
