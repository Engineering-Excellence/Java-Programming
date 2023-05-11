package ex02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class GiftInsert {

    private static final Logger LOGGER = Logger.getLogger(GiftInsert.class.getName());

    public static void main(String[] args) throws SQLException {

        // 1. Driver Load
        /*
            Class.forName("oracle.jdbc.driver.OracleDriver");
            LOGGER.info("Driver Load SUCCESS!");
        */

        // 2. Connection & Open
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "KOSA", "java");
        LOGGER.info("Connection SUCCESS!");

        // 3. SQL
        Statement stmt = conn.createStatement();
        // INSERT INTO gift VALUES (11, '종합과자', 1000, 20000);
        // ① (stmt) 고정값 레코드 입력
//        String sql = "INSERT INTO GIFT VALUES (11, '종합과자', 1000, 20000)";   // AUTO COMMIT
        // ② (stmt) 레코드 값을 입력 받아서 처리 - Scanner, IO, args, BufferedReader
        String sql = "INSERT INTO GIFT VALUES (" + args[0] + ", '" + args[1] + "', " + args[2] + ", " + args[3] + ")";
        LOGGER.info(sql);
        int result = stmt.executeUpdate(sql);
        LOGGER.info(result + "개 데이터 추가 성공");

        // 4. Close(자원 반환)
        stmt.close();
        conn.close();
    }
}
