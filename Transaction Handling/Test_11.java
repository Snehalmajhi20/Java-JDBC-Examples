import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test_11 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String username = "";
        String password = "";
        String withdrawQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
        String depositQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class Driver Load Successfully....");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully....");
            con.setAutoCommit(false);
            try{
                PreparedStatement pswithdraw = con.prepareStatement(withdrawQuery);
                PreparedStatement psdeposit = con.prepareStatement(depositQuery);

//                Scanner sc = new Scanner(System.in);
//                System.out.print("Enter the Account Number: ");
//                String ac = sc.nextLine();
//                System.out.print("Enter Withdraw account: ");
//                Double ac1 = sc.nextDouble();
//                sc.nextLine();
//                System.out.print("Enter the Account Number: ");
//                String ac2 = sc.nextLine();
//                System.out.print("Enter Deposit Amount: ");
//                Double ac3 = sc.nextDouble();
                pswithdraw.setDouble(1,100);
                pswithdraw.setString(2,"account123");
                psdeposit.setDouble(1,500);
                psdeposit.setString(2,"account594");

                pswithdraw.executeUpdate();
                psdeposit.executeUpdate();
                con.commit();
                System.out.println("Transaction Successfully....");

            }
            catch (SQLException e) {
                con.rollback();
                System.out.println("Transaction Successfully....");
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
