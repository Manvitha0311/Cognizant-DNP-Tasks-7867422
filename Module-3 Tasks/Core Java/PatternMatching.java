public class PatternMatching {

    static void identify(Object obj) {

        if (obj instanceof Integer) {
            System.out.println("You gave an Integer: " + obj);
        } else if (obj instanceof String) {
            System.out.println("You gave a String: " + obj);
        } else if (obj instanceof Double) {
            System.out.println("You gave a Double: " + obj);
        } else if (obj == null) {
            System.out.println("You gave nothing (null)");
        } else {
            System.out.println("Not sure what this is: " + obj);
        }
    }

    public static void main(String[] args) {

        identify(25);
        identify("Java is fun");
        identify(3.14);
        identify(null);
        identify(true);
    }
}