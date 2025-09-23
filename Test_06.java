import java.sql.*;

public class Test_06 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String username = "";
        String password = "";
        String query = "select * from student where name IN (?, ?, ?)";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Class loaded Successfully......");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully........");

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,"Snehal Majhi");
            ps.setString(2,"Jagannath");
            ps.setString(3,"Saroj Sahoo");
//            ps.setString(2,"Snehal Majhi");
            //ps.setString();
            //ps.setString();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String Name = rs.getString("name");
                String Job = rs.getString("job");
                double Salary = rs.getDouble("salary");

                System.out.println("ID: "+id+", NAME: "+Name+", JOB: "+Job+", SALARY: "+Salary);
            }
            ps.close();
            rs.close();
            con.close();
            System.out.println();
            System.out.println("Connection Closed Successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
