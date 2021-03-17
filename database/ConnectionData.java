import java.sql.*;
// class ConnectionData {
//     public static void main(String[] args) throws SQLException {

//         Connection con=null;
//         try {
            
//             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/I4GIC2021", "admin", "admin4321");
//             System.out.println("connection successful");
//             Statement stat=con.createStatement();
            
//         } catch (SQLException e) {
//             System.err.println(e.getMessage());
//         }
//     }
// }
// import java.sql.*;
public class ConnectionData {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.err.println(e.getMessage());
            return;
        }
        Connection con = null;
        try {
            /*con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/I4GIC2021",
                    "i42021_user","123456");
              stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " +
                    "`counters`(`id` INT AUTO_INCREMENT PRIMARY KEY," +
                    "`count` INT, `note` VARCHAR(100))");
                System.out.println("Table counters is created.");*/
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/",
                    "admin","admin4321");
            System.out.println("Connection successful!");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE DATABASE `i4GIC2020_21`");
            System.out.println("Database i4GIC2020_21 is created.");
            // stmt.executeUpdate("GRANT all privileges on i4GIC2020_21.* " +
            //         "to i4_other_user@localhost identified by '123456'");
            stmt.executeUpdate("create user i4_other_user@localhost identified by '123456' ");
            stmt.executeUpdate("GRANT all privileges on iGIC2020_21.* to i4_other_user@localhost");
            System.out.println("User i4_other_user is created with password 123456.");
            stmt.executeUpdate("use i4GIC2020_21");
            System.out.println("Database changed to i4GIC2020_21.");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " +
                    "`counters`(`id` INT AUTO_INCREMENT PRIMARY KEY," +
                    "`count` INT, `note` VARCHAR(100))");
            System.out.println("Table counters is created.");
            stmt.executeUpdate("Insert into `counters`(`count`,`note`) values(100,'A Hundred')");
            System.out.println("Data is inserted.");
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            if(con != null) con.close();
        }
    }
}