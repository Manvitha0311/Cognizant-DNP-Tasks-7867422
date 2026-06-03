import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionHandling {

    static String url = "jdbc:mysql://localhost:3306/bank";
    static String user = "root";
    static String password = "your_password";

    static void transfer(int fromId, int toId, double amount) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            debit.setDouble(1, amount);
            debit.setInt(2, fromId);
            debit.executeUpdate();

            PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
            credit.setDouble(1, amount);
            credit.setInt(2, toId);
            credit.executeUpdate();

            conn.commit();
            System.out.println("Transfer successful.");

            debit.close();
            credit.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
                System.out.println("Transaction rolled back.");
            } catch (Exception ex) {
                System.out.println("Rollback error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        transfer(101, 102, 500.0);
    }
}