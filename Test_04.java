import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Test_04 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String username = "";
        String password = "";
        String query = "delete from student where id = 5";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class Load into Driver Successfully");

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected To the Database......");

            Statement st = connection.createStatement();
            int rowsaffected = st.executeUpdate(query);
            if (rowsaffected>0){
                System.out.println("Query OK, "+rowsaffected +"row affected and deleted");
            }
            else {
                System.out.println("Syntax Error!");
            }
        }
        catch (ClassNotFoundException e){
            System.out.println("Class load failed..."+ e.getMessage());
        }
        catch (SQLException e){
            System.out.println("Connection Failed!"+e.getMessage());
        }
    }
}
