import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class StudentDAO {

    private final String url = "jdbc:mysql://localhost:3306/college";
    private final String user = "root";
    private final String password = "your_password";

    // Method to get connection
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    // INSERT operation
    public void insertStudent(int id, String name, int age) {
        String query = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record inserted successfully.");

        } catch (Exception e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }

    // UPDATE operation
    public void updateStudent(int id, String name, int age) {
        String query = "UPDATE students SET name = ?, age = ? WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record updated successfully.");

        } catch (Exception e) {
            System.out.println("Update Error: " + e.getMessage());
        }
    }
}