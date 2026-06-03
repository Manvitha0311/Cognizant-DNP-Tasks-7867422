public class PatternMatchingSwitch {

    static void identifyObject(Object obj) {

        if (obj instanceof Integer) {
            Integer i = (Integer) obj;
            System.out.println("It is an Integer: " + i);
        } else if (obj instanceof String) {
            String s = (String) obj;
            System.out.println("It is a String: " + s);
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            System.out.println("It is a Double: " + d);
        } else if (obj instanceof Float) {
            Float f = (Float) obj;
            System.out.println("It is a Float: " + f);
        } else if (obj instanceof Boolean) {
            Boolean b = (Boolean) obj;
            System.out.println("It is a Boolean: " + b);
        } else {
            System.out.println("Unknown type: " + obj);
        }
    }

    public static void main(String[] args) {

        identifyObject(100);
        identifyObject("Hello Java");
        identifyObject(45.67);
        identifyObject(true);
        identifyObject('A');
    }
}