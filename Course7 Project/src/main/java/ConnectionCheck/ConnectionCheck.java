package ConnectionCheck;
import java.sql.*;
public class ConnectionCheck {
        public static Connection getConnection() throws SQLException
        {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","Password@123");
            return con;
        }
}