package db_conn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/*
    ConnectionHelper 클래스의 문제
    매번 드라이버 로드, 연결 생성 -> 자원 낭비

    공유자원(싱글톤)으로 해결!
*/
public class ConnectionSingletonHelper {

    private static Connection conn;
    static final Logger LOGGER = Logger.getLogger(ConnectionSingletonHelper.class.getName());

    private ConnectionSingletonHelper() {
    }

    public static Connection getConnection(String dsn, String uid, String pwd) {
        if (conn != null) return conn;

        try {
            if (dsn.equalsIgnoreCase("ORACLE")) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", uid, pwd);
                LOGGER.info("ORACLE 연결 성공!");
            } else if (dsn.equalsIgnoreCase("MySQL")) {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KOSA", uid, pwd);
                LOGGER.info("MySQL 연결 성공!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void close(){
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                LOGGER.info("ORACLE 연결 종료");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
