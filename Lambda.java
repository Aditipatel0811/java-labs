import java.util.ArrayList;
import java.util.List;

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

public class Lambda {
    public static void main(String[] args) {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Alice", 25));
        passengers.add(new Passenger("Bob", 3));
        passengers.add(new Passenger("Charlie", 18));
        passengers.add(new Passenger("David", 35));

        // Using lambda expression to filter passengers based on age
        List<Passenger> adults = filterPassengers(passengers, passenger -> passenger.getAge() >= 18);

        // Displaying the filtered passengers
        System.out.println("Adult Passengers:");
        adults.forEach(System.out::println);
    }

    // Generic method to filter a list based on a given predicate
    private static <T> List<T> filterPassengers(List<T> passengers, PassengerPredicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T passenger : passengers) {
            if (predicate.test(passenger)) {
                result.add(passenger);
            }
        }
        return result;
    }

    // Functional interface for passenger predicate
    @FunctionalInterface
    interface PassengerPredicate<T> {
        boolean test(T passenger);
    }
}
