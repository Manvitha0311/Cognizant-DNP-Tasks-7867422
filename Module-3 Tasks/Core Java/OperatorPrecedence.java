public class OperatorPrecedence{
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1);

        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2);

        int result3 = 20 / 4 + 3 * 2 - 1;
        System.out.println("20 / 4 + 3 * 2 - 1 = " + result3);

        boolean result4 = 5 > 3 && 8 < 10;
        System.out.println("5 > 3 && 8 < 10 = " + result4);
    }
}