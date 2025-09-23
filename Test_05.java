import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Test_05 {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/emp";
        String username = "root";
        String password = "1220";
        String query = "UPDATE student SET job = 'Odisha Police' WHERE id = 5";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class load Sucessfully");

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successfully into Database");

            Statement st = connection.createStatement();
            int rowsaffected = st.executeUpdate(query);
            if (rowsaffected >0){
                System.out.println("Query OK, "+rowsaffected+" row affected and ");
            }
            else {
                System.out.println("Syntax error");
            }
        }
        catch (ClassNotFoundException e){
            System.out.println("Class Load Driver failed"+e.getMessage());
        }
        catch (SQLException e){
            System.out.println("Connection failed"+e.getMessage());
        }
    }
}
