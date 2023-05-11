package ex02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class GiftInsert2 {

    private static final Logger LOGGER = Logger.getLogger(GiftInsert2.class.getName());

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
        // INSERT INTO gift VALUES (11, '종합과자', 1000, 20000);
        // ③ (pstmt) 고정값 레코드 입력
        String sql = "INSERT INTO GIFT VALUES (?, ?, ?, ?)";   // AUTO COMMIT
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 20);
        pstmt.setString(2, "초콜릿");
        pstmt.setInt(3, 3000);
        pstmt.setInt(4, 9999);
        int result = pstmt.executeUpdate();
        LOGGER.info(result + "개 데이터 추가 성공");

        // 4. Close(자원 반환)
        pstmt.close();
        conn.close();
    }
}
