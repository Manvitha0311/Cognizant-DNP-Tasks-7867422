import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionDemo {

    static String url = "jdbc:mysql://localhost:3306/bank";
    static String user = "root";
    static String password = "your_password";

    public static void transfer(int fromId, int toId, double amount) {

        String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        String checkQuery = "SELECT balance FROM accounts WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            con.setAutoCommit(false); // Start transaction

            // Check sender balance
            PreparedStatement checkStmt = con.prepareStatement(checkQuery);
            checkStmt.setInt(1, fromId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getDouble("balance") < amount) {
                System.out.println("Insufficient balance!");
                con.rollback();
                return;
            }

            // Debit from sender
            PreparedStatement debitStmt = con.prepareStatement(debitQuery);
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromId);
            debitStmt.executeUpdate();

            // Credit to receiver
            PreparedStatement creditStmt = con.prepareStatement(creditQuery);
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toId);
            creditStmt.executeUpdate();

            con.commit(); // Commit transaction
            System.out.println("Transfer successful!");

        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
            try {
                DriverManager.getConnection(url, user, password).rollback();
            } catch (Exception ex) {
                System.out.println("Rollback error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        transfer(1, 2, 1000);
    }
}