import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortingExample {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Sreeja");
        names.add("Anu");
        names.add("Priya");
        names.add("Zara");
        names.add("Bhavya");

        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        System.out.println("Sorted Names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}