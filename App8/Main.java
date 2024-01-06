import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String connectionURL = "jdbc:mysql://localhost:3306/javadb";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectionURL, username, password);
            
            
            String query = "select * from emp where id = ?";
            
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, 1);

            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("id")+ " | " + rs.getString("name") + " | " + rs.getString("email") + " | " + rs.getString("mobile"));
            }

            rs.close();
            pst.close();
            con.close();

        } catch(ClassNotFoundException e) {
            System.out.println(e);
        } catch(SQLException e) {
            System.out.println(e);
        }
    }    
}
