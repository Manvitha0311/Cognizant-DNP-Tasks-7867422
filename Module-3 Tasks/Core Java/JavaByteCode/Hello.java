package JavaByteCode;

public class Hello {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Hello obj = new Hello();
        int result = obj.add(10, 20);
        System.out.println("Sum = " + result);
    }
}