public class Demo {

    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        Demo obj = new Demo();
        int result = obj.multiply(5, 10);
        System.out.println("Result: " + result);
    }
}