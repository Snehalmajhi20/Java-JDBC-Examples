import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test_09 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String username = "root";
        String password = "1220";
        String image_path = "D:\\JBDC\\img\\Javaimg.jpg";
        String query = "insert into image_table(image_data) values (?)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class Driver Load Successfully.....");

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Conntion into Database Successfully.....");

            FileInputStream fis = new FileInputStream(image_path);
            byte [] imageData = new byte[fis.available()];
            fis.read(imageData);

            PreparedStatement ps = con.prepareStatement(query);
            ps.setBytes(1, imageData);

            int AffectedRows = ps.executeUpdate();
            if (AffectedRows>0){
                System.out.println("Image inserted Successfully into Database...");
            }
            else {
                System.out.println("Insertion Failed.....");
            }
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
