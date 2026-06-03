package ReflectionInJava;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {
    public static void main(String[] args) {

        try {
            // Load class dynamically
            Class<?> cls = Class.forName("ReflectionInJava.Calculator");

            // Create object dynamically
            Object obj = cls.getDeclaredConstructor().newInstance();

            // Get all declared methods
            Method[] methods = cls.getDeclaredMethods();

            System.out.println("Methods in Calculator class:");

            for (Method method : methods) {
                System.out.print("Method: " + method.getName());

                Parameter[] params = method.getParameters();
                System.out.print(" | Parameters: ");

                for (Parameter p : params) {
                    System.out.print(p.getType().getSimpleName() + " ");
                }

                System.out.println();
            }

            // Invoke add() dynamically
            Method addMethod = cls.getDeclaredMethod("add", int.class, int.class);

            Object result = addMethod.invoke(obj, 10, 20);

            System.out.println("Result of add(): " + result);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}