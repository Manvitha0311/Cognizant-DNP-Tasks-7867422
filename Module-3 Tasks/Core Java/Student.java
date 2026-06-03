//39-1
public class Student {

    String name;
    int age;

    public Student() {
        this.name = "Unknown";
        this.age = 0;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void secretMethod() {
        System.out.println("This is a private secret method!");
    }
}