import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Passenger {
    private String name;
    private int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Adultpassenger {
    public static void main(String[] args) {
        // ArrayList
        List<Passenger> passengersArrayList = new ArrayList<>();
        passengersArrayList.add(new Passenger("Amal", 25));
        passengersArrayList.add(new Passenger("Banita", 3));
        passengersArrayList.add(new Passenger("Chaitri", 18));
        passengersArrayList.add(new Passenger("David", 35));

        displayFilteredPassengers(passengersArrayList, "Passengers Traveling from AirIndia");

        // LinkedList
        List<Passenger> passengersLinkedList = new LinkedList<>();
        passengersLinkedList.add(new Passenger("Emanuel", 25));
        passengersLinkedList.add(new Passenger("Faiz", 3));
        passengersLinkedList.add(new Passenger("Gaurav", 18));
        passengersLinkedList.add(new Passenger("Harsh", 35));

        displayFilteredPassengers(passengersLinkedList, "Passengers Traveling from AkasaAir");

        // HashSet
        Set<Passenger> passengersHashSet = new HashSet<>();
        passengersHashSet.add(new Passenger("Ishan", 25));
        passengersHashSet.add(new Passenger("Jack", 3));
        passengersHashSet.add(new Passenger("Kunal", 18));
        passengersHashSet.add(new Passenger("Lahari", 35));

        displayFilteredPassengers(new ArrayList<>(passengersHashSet), "Passengers traveling From Indigo");
    }

    private static void displayFilteredPassengers(List<Passenger> passengers, String collectionType) {
        // Using lambda expression to filter passengers based on age
        List<Passenger> adults = filterPassengers(passengers, passenger -> passenger.getAge() >= 18);

        // Displaying the filtered passengers
        System.out.println(collectionType + " - Adult Passengers:");
        adults.forEach(System.out::println);
        System.out.println();
    }

    private static <T> List<T> filterPassengers(List<T> passengers, PassengerPredicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T passenger : passengers) {
            if (predicate.test(passenger)) {
                result.add(passenger);
            }
        }
        return result;
    }

    @FunctionalInterface
    interface PassengerPredicate<T> {
        boolean test(T passenger);
    }
}
