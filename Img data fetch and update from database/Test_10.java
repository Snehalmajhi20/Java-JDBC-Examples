import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Test_10 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String username = "root";
        String password = "1220";
        String folder_path = "D:\\JBDC\\img\\";
        String query = "select image_data from image_table where image_id = (?)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class Driver Loaded Successfully.....");

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully......");

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,1);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                byte [] image_Data = rs.getBytes("image_data");
                String image_path = folder_path + "extractedImage.jpg";
                OutputStream os = new FileOutputStream(image_path);
                os.write(image_Data);
                System.out.println("image Found");
                System.out.println("The image Pull from database to file successfully");
            }
            else {
                System.out.println("image not Found...");
            }
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
