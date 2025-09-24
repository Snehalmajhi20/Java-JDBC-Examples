import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_12 {
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

            Statement st = con.createStatement();
            st.addBatch("insert into student (id, name, job, salary) values(8, 'Satabdi', 'Software Engineer', 35000)");
            st.addBatch("insert into student (id, name, job, salary) values(9, 'Rajkishor', 'Government Officer', 30000)");
            st.addBatch("insert into student (id, name, job, salary) values(10,'Sambit', 'Desktop Engineer', 25000)");

            int [] data = st.executeBatch();
            con.commit();
            System.out.println("insert the data....");

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
