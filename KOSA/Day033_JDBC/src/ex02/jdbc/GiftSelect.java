package ex02.jdbc;

import java.sql.*;
import java.util.logging.Logger;

public class GiftSelect {

    private static final Logger LOGGER = Logger.getLogger(GiftSelect.class.getName());

    public static void main(String[] args) throws SQLException {

        // 1. Driver Load
        /*
            Class.forName("oracle.jdbc.driver.OracleDriver");
            logger.info("Driver Load SUCCESS!");
        */

        // 2. Connection & Open
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "KOSA", "java");
        LOGGER.info("Connection SUCCESS!");

        // 3. SQL
        Statement stmt = conn.createStatement();
        // executeQuery("SQL"): 반환값이 있는 경우(SELECT)
        ResultSet rs = stmt.executeQuery("SELECT * FROM gift WHERE gno BETWEEN 3 and 7");
        System.out.println("상품번호\t\t상품명\t\t최저가\t\t최고가");
        while (rs.next()) { // ResultSet의 CURSOR 초기 위치는 필드
            int gno = rs.getInt(1);
            String gname = rs.getString("gname");
            int g_start = rs.getInt(3);
            int g_end = rs.getInt("g_end");
            System.out.printf("%6d\t%9s\t%8d\t%8d%n", gno, gname, g_start, g_end);
        }   // while end

        // 4. Close(자원 반환)
        rs.close();
        stmt.close();
        conn.close();
        LOGGER.info("Connection CLOSED");
    }
}
