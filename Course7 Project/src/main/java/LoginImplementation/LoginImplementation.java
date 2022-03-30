package LoginImplementation;

import ConnectionCheck.ConnectionCheck;

import java.sql.*;
import java.util.*;
public class LoginImplementation {
    public static boolean authenticationCheck(String username,String password) throws SQLException{
        Connection con= ConnectionCheck.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from authentication");
        while(rs.next()) {
            if(rs.getString(1).equals(username) ){
                if(rs.getString(2).equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void createAccount() throws SQLException{
        Connection con= ConnectionCheck.getConnection();
        long mob=0;
        int y;
        do {
            y=0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Your Name");
            String name = sc.next();
            try {
                System.out.println("Enter Your Mobile Number(Must be unique)");
                mob = sc.nextLong();
            System.out.println("Enter Your User Name");
            String uname = sc.next();
            System.out.println("Enter Your Password");
            String pword = sc.next();
            try {
                PreparedStatement ps = con.prepareStatement("insert into authentication values(?,?,?,?);");
                ps.setString(1, uname);
                ps.setString(2, pword);
                ps.setString(3, name);
                ps.setLong(4, mob);
                int rowsaffected = ps.executeUpdate();
                if (rowsaffected != 0) {
                    System.out.println("Your Account created sucussfully");
                }
                else
                    System.out.println("Your Account was not created");
            } catch (SQLException e) {
                System.out.println("Mobile Number/Username has been taken");
                y++;
            }
            } catch(InputMismatchException e){
                System.out.println("Mobile Number can only be a numeric entry");
                y++;
            }
        } while(y!=0);
    }
}
