import java.sql.*;
import java.util.Scanner;

public class Test_13 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String username = "root";
        String password = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver class load successfully....");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");
            con.setAutoCommit(false);

            String query = "insert into student ( name, job, salary) values( ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            Scanner sc = new Scanner(System.in);

            while(true){
                System.out.print("Enter the id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter the name: ");
                String name = sc.nextLine();
                System.out.print("Enter the job: ");
                String job = sc.nextLine();
                System.out.print("Enter the salary: ");
                Double salary = sc.nextDouble();
                sc.nextLine();
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, job);
                ps.setDouble(4, salary);
                ps.addBatch();
                System.out.println("add more values(Y/N)");
                String decision = sc.nextLine();
                if(decision.equals("N")){
                    break;
                }
            }
            int [] data = ps.executeBatch();
            con.commit();
            System.out.println("Insertion Successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

