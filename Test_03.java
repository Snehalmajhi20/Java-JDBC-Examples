import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_03 {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/emp";
        String username = "root";
        String password = "1220";
        String query = "insert into student(id, name, job, salary) values(5, 'Amlan Dash', 'Government', 35000)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class loader Driver Successfully!");

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Made Successfully");

            Statement st = connection.createStatement();
            int rowsaffected = st.executeUpdate(query);

            if(rowsaffected>0){
                System.out.println("Query OK, "+rowsaffected+" rows affected");
            }
            else {
                System.out.println("You have an error in your syntax check again!");
            }
            st.close();
        } catch (ClassNotFoundException e){
            System.out.println("Connection loading failed");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
