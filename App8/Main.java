import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String connectionURL = "jdbc:mysql://localhost:3306/javadb";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectionURL, username, password);
            Statement st = con.createStatement();

            String query = "select * from emp";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                System.out.println(rs.getString("id")+ " | " + rs.getString("name") + " | " + rs.getString("email") + " | " + rs.getString("mobile"));
            }

            rs.close();
            st.close();
            con.close();

        } catch(ClassNotFoundException e) {
            System.out.println(e);
        } catch(SQLException e) {
            System.out.println(e);
        }
    }    
}
