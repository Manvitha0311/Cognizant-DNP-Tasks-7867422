//32

import java.sql.*;

public class StudentDAO {

    static final String URL = "jdbc:mysql://localhost:3306/school";
    static final String USER = "root";
    static final String PASSWORD = "Padma";

    Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    void insertStudent(int id, String name, int age) {
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.executeUpdate();
            System.out.println("Student inserted: " + name);

        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    void updateStudent(int id, String newName, int newAge) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setInt(2, newAge);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Student updated with ID: " + id);

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        dao.insertStudent(1, "Alice", 20);
        dao.insertStudent(2, "Bob", 22);

        dao.updateStudent(1, "Alice Smith", 21);
    }
}