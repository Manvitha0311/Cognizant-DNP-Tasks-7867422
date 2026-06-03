import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class Records{
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("A", 22),
            new Person("B", 17),
            new Person("C", 30),
            new Person("D", 15)
        );

        System.out.println("All people:");
        people.forEach(System.out::println);

        List<Person> adults = people.stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.toList());

        System.out.println("\nAdults (18+):");
        adults.forEach(System.out::println);
    }
}