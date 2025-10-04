import java.sql.*;
import java.util.Scanner;

public class Test_08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/coolcoders";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Username: ");
        String dbusername = sc.nextLine();
        System.out.println("Enter Your Password: ");
        String dbpassword = sc.nextLine();

        String username = dbusername;
        String password = dbpassword;

        System.out.print("Enter your name: ");
        String s_name = sc.nextLine();
        System.out.print("Enter your Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your Stream: ");
        String stream = sc.nextLine();
        System.out.print("Enter your Location: ");
        String city = sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        String query = "INSERT INTO friends(name, age, stream, city, email) VALUES('" + s_name + "', " + age + ", '" + stream + "', '" + city + "', '" + email + "')";
        String query_01 = "SELECT * FROM friends";
        Connection con = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Class load successfully");

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Database successfully.....");

            st = con.createStatement();
            int rowaffacted = st.executeUpdate(query);
            if (rowaffacted>0){
                System.out.println("Data inserted successfully");
            }
            else {
                System.out.println("Data inserted failed, please try again....");
            }
            ResultSet rs = st.executeQuery(query_01);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int fage = rs.getInt("age");
                String fstream = rs.getString("stream");
                String fcity = rs.getString("city");
                String femail = rs.getString("email");

                System.out.println("Friend ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("AGE IS: "+fage);
                System.out.println("Stream is: "+fstream);
                System.out.println("Location: "+fcity);
                System.out.println("Email Address: "+femail);
            }
            con.close();
            st.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
