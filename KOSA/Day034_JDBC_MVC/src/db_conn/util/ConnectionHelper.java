package db_conn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/*
    DB 연결 정보 반복적인 코딩을 해결
    다른 클래스에서 아래 코드 구현을 하지 않도록 설계

    Class.forName("oracle.jdbc.driver.OracleDriver");
    if (conn == null) conn = DriverManager.getConnection(url, uid, pwd);

    이런 식으로 사용
    ConnectionHelper.getConnection("oracle") or ("mysql")
*/
public class ConnectionHelper {

    static final Logger LOGGER = Logger.getLogger(ConnectionHelper.class.getName());

    public static Connection getConnection(String dsn, String uid, String pwd) {
        Connection conn = null;
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
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return conn;
        }
    }

    public static void menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-=-=-=-=-= JDBC Query =-=-=-=-=-\n");
        sb.append("\t0. ROLLBACK\n");
        sb.append("\t1. 전체 보기\n");
        sb.append("\t2. 레코드 삽입(추가)\n");
        sb.append("\t3. 레코드 수정\n");
        sb.append("\t4. 레코드 삭제\n");
        sb.append("\t5. 조건부 검색\n");
        sb.append("\t6. 프로그램 종료\n");
        sb.append("\t9. COMMIT\n");
        sb.append("\n원하는 메뉴를 선택하세요: ");
        System.out.print(sb);
    }
}
