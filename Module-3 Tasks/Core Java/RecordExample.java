import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class RecordExample {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Sreeja", 20),
                new Person("Anu", 17),
                new Person("Priya", 22),
                new Person("Rahul", 16),
                new Person("Kiran", 25)
        );

        System.out.println("All Persons:");
        for (Person p : people) {
            System.out.println(p);
        }

        List<Person> adults = people.stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.toList());

        System.out.println("\nPersons aged 18 and above:");
        for (Person p : adults) {
            System.out.println(p);
        }
    }
}