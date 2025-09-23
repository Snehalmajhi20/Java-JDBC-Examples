//import static java.lang.Class.forName;
import java.sql.*;

public class Test_01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String username = "";
        String password = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver load Sucessfully!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Establish successfully!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from emp");
            while (rs.next()){
                int emp_id = rs.getInt("emp_id");
                String emp_name = rs.getString("emp_name");
                String email = rs.getString("email");
                String location = rs.getString("location");
                String department = rs.getString("department");
                String gender = rs.getString("gender");
                String status = rs.getString("status");

                System.out.println("ID: " + emp_id + ", Name: " + emp_name + ", Email: " + email +
                        ", Location: " + location + ", Department: " + department +
                        ", Gender: " + gender + ", Status: " + status);
            }
            rs.close();
            st.close();
            con.close();
        }
        catch (SQLException e){
            System.out.println("Connection Failed! "+e.getMessage());
        }
    }
}
