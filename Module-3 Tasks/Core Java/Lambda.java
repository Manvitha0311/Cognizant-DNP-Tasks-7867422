import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda{
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Mango", "Apple", "Banana", "Cherry", "Grape");

        Collections.sort(fruits, (a, b) -> a.compareTo(b));

        System.out.println("Sorted list:");
        fruits.forEach(f -> System.out.println(f));
    }
}