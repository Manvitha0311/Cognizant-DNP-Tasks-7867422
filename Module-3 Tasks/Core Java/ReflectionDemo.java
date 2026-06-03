//39-2
import java.lang.reflect.*;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {

        Class<?> cls = Class.forName("Student");
        System.out.println("Class Name : " + cls.getName());
        System.out.println("Simple Name: " + cls.getSimpleName());

        System.out.println("\n--- All Declared Methods ---");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print("Method : " + method.getName() + "(");
            Class<?>[] params = method.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getSimpleName());
                if (i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }

        System.out.println("\n--- Creating Object Using Reflection ---");
        Constructor<?> constructor = cls.getConstructor(String.class, int.class);
        Object studentObj = constructor.newInstance("Alice", 22);

        System.out.println("\n--- Invoking displayInfo() ---");
        Method displayInfo = cls.getMethod("displayInfo");
        displayInfo.invoke(studentObj);

        System.out.println("\n--- Invoking getName() ---");
        Method getName = cls.getMethod("getName");
        String name = (String) getName.invoke(studentObj);
        System.out.println("Returned Name: " + name);

        System.out.println("\n--- Invoking setName() ---");
        Method setName = cls.getMethod("setName", String.class);
        setName.invoke(studentObj, "Bob");

        Method displayInfo2 = cls.getMethod("displayInfo");
        displayInfo2.invoke(studentObj);

        System.out.println("\n--- Invoking Private Method ---");
        Method secret = cls.getDeclaredMethod("secretMethod");
        secret.setAccessible(true);
        secret.invoke(studentObj);

        System.out.println("\n--- All Constructors ---");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for (Constructor<?> con : constructors) {
            System.out.print("Constructor: " + con.getName() + "(");
            Class<?>[] paramTypes = con.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getSimpleName());
                if (i < paramTypes.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }

        System.out.println("\n--- All Fields ---");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field.getType().getSimpleName() + " " + field.getName());
        }
    }
}