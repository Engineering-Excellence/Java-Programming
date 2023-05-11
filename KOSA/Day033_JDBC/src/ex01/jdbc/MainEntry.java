package ex01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class MainEntry {

    private static final Logger LOGGER = Logger.getLogger(MainEntry.class.getName());

    public static void main(String[] args) throws SQLException {

        // 1. Driver Load: Exception 발생
        /*
    //        Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("oracle.jdbc.OracleDriver");
            logger.info("Driver Load SUCCESS!");
         */

        // 2. Connection & Open
        // driver:@IP:port:SID
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
        String uid = "KOSA";
        String pwd = "java";

        Connection conn = DriverManager.getConnection(url, uid, pwd);
        LOGGER.info("Connection SUCCESS!");

        // 3. SQL


        // 4. Close(자원 반환)

    }
    // SQL, Tag는 자바에서 문자열 취급
}
