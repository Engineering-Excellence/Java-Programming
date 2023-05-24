package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    public static Connection getConnection(String dsn) throws ClassNotFoundException, SQLException {

        Connection conn = null;
            if (dsn.equalsIgnoreCase("ORACLE")) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "KOSA", "java");
            } else if (dsn.equalsIgnoreCase("MySQL")) {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KOSA", "KOSA", "java");
            }

        return conn;
    }
}
