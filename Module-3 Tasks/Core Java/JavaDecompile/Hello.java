package JavaDecompile;

public class Hello {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Hello obj = new Hello();
        System.out.println("Sum = " + obj.add(10, 20));
    }
}