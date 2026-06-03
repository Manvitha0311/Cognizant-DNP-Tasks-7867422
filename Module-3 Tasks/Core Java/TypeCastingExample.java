public class TypeCastingExample {
    public static void main(String[] args) {

        double d = 45.67;
        int intValue = (int) d;

        int num = 25;
        double doubleValue = (double) num;

        System.out.println("Double value: " + d);
        System.out.println("Double to Int: " + intValue);
        System.out.println("Int value: " + num);
        System.out.println("Int to Double: " + doubleValue);
    }
}