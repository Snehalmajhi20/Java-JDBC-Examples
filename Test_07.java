import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test_07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String username = "";
        String password = "";
        String query = "insert into student (id, name, job, salary) values (?, ?, ?, ?)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver class load successfully.....");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected into DATABASE successfully.....");

            PreparedStatement ps = con.prepareStatement(query);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your job name: ");
            String job = sc.nextLine();
            System.out.print("Enter your salary: ");
            Double salary = sc.nextDouble();

            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,job);
            ps.setDouble(4,salary);

            int rowaffected = ps.executeUpdate();

            if (rowaffected>0){
                System.out.println("Insert row Successfully...");
            }
            else {
                System.out.println("Insert data in database failed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
