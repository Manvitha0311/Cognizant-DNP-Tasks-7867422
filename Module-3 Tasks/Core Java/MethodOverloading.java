public class MethodOverloading{

    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("Sum of 3 and 5: " + add(3, 5));
        System.out.println("Sum of 2.5 and 4.3: " + add(2.5, 4.3));
        System.out.println("Sum of 1, 2 and 3: " + add(1, 2, 3));
    }
}