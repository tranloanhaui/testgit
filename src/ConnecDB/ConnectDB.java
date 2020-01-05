package ConnecDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    private static String dbURL = "jdbc:mysql://localhost:3309/COP";
    private static String username = "sa";
    private static String password = "123";


    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, username, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
