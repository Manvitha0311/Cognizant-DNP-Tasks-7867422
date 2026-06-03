import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "your_password";

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Create statement
            Statement stmt = con.createStatement();

            // Execute query
            String query = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(query);

            // Display results
            System.out.println("Student Records:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("name") + " - " +
                        rs.getInt("age")
                );
            }

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}