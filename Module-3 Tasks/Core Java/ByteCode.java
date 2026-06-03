public class ByteCode{

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        ByteCode obj = new ByteCode();
        int result = obj.add(10, 20);
        System.out.println("Result: " + result);
    }
}