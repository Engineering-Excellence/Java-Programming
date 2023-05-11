package ex02.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class GiftInsert3 {

    private static final Logger LOGGER = Logger.getLogger(GiftInsert3.class.getName());
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws SQLException, IOException {

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
        System.out.print("Gift Table Data Input(상품번호/상품명/최저가/최고가): ");
        StringTokenizer st = new StringTokenizer(BR.readLine(), "/");
        // ④ (pstmt) 레코드 값을 입력 받아서 처리 - Scanner, IO, args, BufferedReader
        String sql = "INSERT INTO GIFT VALUES (?, ?, ?, ?)";   // AUTO COMMIT
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, Integer.parseInt(st.nextToken()));
        pstmt.setString(2, st.nextToken());
        pstmt.setInt(3, Integer.parseInt(st.nextToken()));
        pstmt.setInt(4, Integer.parseInt(st.nextToken()));
        int result = pstmt.executeUpdate();
        LOGGER.info(result > 0 ? String.format("%d개 데이터 추가 성공", result) : "데이터 추가 실패");

        // 4. Close(자원 반환)
        pstmt.close();
        conn.close();
    }
}
