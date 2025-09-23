import java.sql.*;
class Test_02
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/emp";
        String username = "root";
        String password ="1220";
        String query = "select * from student";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver class load Successfully");

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Into Database successfully");

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                double salary = rs.getDouble("salary");
                System.out.println(id+", "+name+", "+job+", "+salary);
//                System.out.println("ID: "+ id+", name: "+name +", job: "+job+", salary: "+salary);

            }
            st.close();
            connection.close();
            System.out.println();
            System.out.println("Connection Closed!");
        }
        catch (ClassNotFoundException e){
            System.out.println("Driver class load failed"+e.getMessage());
        }
        catch (SQLException e){
            System.out.println("Connection Failed"+e.getMessage());
        }
    }
}

