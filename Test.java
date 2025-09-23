import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/emp";
        String username = "root";
        String password = "1220";
//        Connection con = DriverManager.getConnection(url, username, password);
//        System.out.println("Connection Establish into the database!");

        try(Connection con = DriverManager.getConnection(url, username, password)){
            System.out.println("Connection Establish into the database");
        }
        catch (SQLException e){
            System.out.println("Connection Failed: "+e.getMessage());
        }
    }
}
