package ex02.jdbc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import static db.DBConnection.getConnection;

public class EmpServiceImpl implements EmpService {

    private static final EmpService INSTANCE = new EmpServiceImpl("jdbc:oracle:thin:@127.0.0.1:1521:XE", "KOSA", "java");
    private static java.sql.Connection conn;
    private static java.sql.PreparedStatement pstmt;
    private static java.sql.Statement stmt;
    private static java.sql.ResultSet rs;
    static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private EmpServiceImpl(String url, String uid, String pwd) {

        Logger logger = Logger.getLogger(EmpServiceImpl.class.getName());
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            logger.info("Dirver Load SUCCESS!");
            if (conn == null) conn = DriverManager.getConnection(url, uid, pwd);
            logger.info("Connection SUCCESS!");
            System.out.println("인사관리 시스템에 접속하신 것을 환영합니다.");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static EmpService getInstance() {

        return INSTANCE;
    }

    @Override
    public String selectByEmpNo(int n) throws SQLException {

        StringBuilder sb = new StringBuilder();
        String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, n);

        rs = pstmt.executeQuery();
        while (rs.next()) {
            for (int i = 1; i <= 8; i++)
                sb.append(rs.getString(i)).append(" ");
            sb.append("\n");
        } // while end
        System.out.println(sb);
        return sb.toString();
    }

    @Override
    public String selectByNoBtw(int startn, int endn) throws SQLException {

        StringBuilder sb = new StringBuilder();
        String sql = "SELECT * FROM EMP WHERE EMPNO BETWEEN ? AND ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, startn);
        pstmt.setInt(2, endn);

        rs = pstmt.executeQuery();
        while (rs.next()) {
            for (int i = 1; i <= 8; i++)
                sb.append(rs.getString(i)).append(" ");
            sb.append("\n");
        } // while end
        System.out.println(sb);
        return sb.toString();
    }

    @Override
    public String selectAll() throws SQLException {

        StringBuilder sb = new StringBuilder();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM emp");
        System.out.println("사번\t사원명\t직위\t매니저\t고용일\t급여\t커미션\t부서번호");
        while (rs.next()) {
            int empno = rs.getInt("empno");
            String ename = rs.getString("ename");
            String job = rs.getString("job");
            int mgr = rs.getInt("mgr");
            Date hiredate = rs.getDate("hiredate");
            int sal = rs.getInt("sal");
            int comm = rs.getInt("comm");
            int deptno = rs.getInt("deptno");
            sb.append(String.format("%d\t%s\t%s\t%d\t%s\t%d\t%d\t%d%n", empno, ename, job, mgr, hiredate, sal, comm, deptno));
        }   // while end
        stmt.close();
        return sb.toString();
    }

    @Override
    public int insert() throws SQLException, IOException {

        System.out.println("사원번호,사원이름,직급,MGR,입사일,월급,커미션,부서번호순으로 입력 :");
        String sql = "INSERT INTO EMP VALUES(?,?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, Integer.parseInt(BR.readLine()));
        pstmt.setString(2, BR.readLine());
        pstmt.setString(3, BR.readLine());
        pstmt.setInt(4, Integer.parseInt(BR.readLine()));
        pstmt.setString(5, BR.readLine());
        pstmt.setInt(6, Integer.parseInt(BR.readLine()));
        pstmt.setInt(7, Integer.parseInt(BR.readLine()));
        pstmt.setInt(8, Integer.parseInt(BR.readLine()));
        int res = pstmt.executeUpdate();
        System.out.println("입력완료: " + res);
        return res;
    }

    @Override
    public int update() throws IOException {

        System.out.print("수정할 사원번호 입력: ");
        String empno = BR.readLine();

        System.out.print("수정할 칼럼명 입력(job, sal, deptno): ");
        String cName = BR.readLine();

        System.out.print("수정할 값 입력: ");
        String value = BR.readLine();

        if (conn == null) {
            getConnection();
        }

        int res;
        try {
            pstmt = conn.prepareStatement("UPDATE EMP SET " + cName.toUpperCase() + "= ? WHERE EMPNO = ?");
            if (cName.equals("job")) {
                pstmt.setString(1, value.toUpperCase());
            } else {
                pstmt.setInt(1, Integer.parseInt(value));
            }
            pstmt.setInt(2, Integer.parseInt(empno));
            res = pstmt.executeUpdate();
            System.out.println(res + "개행이 수정되었습니다.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//	        exit();
        return res;
    }

    @Override
    public int delete(int empno) throws SQLException, IOException {

        System.out.println("삭제하실 사원 번호를 입력하세요.");
        String sql = "DELETE EMP WHERE EMPNO = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, Integer.parseInt(BR.readLine()));
        int res = pstmt.executeUpdate();

        System.out.println(res + "개 데이터 삭제 성공");
        return res;
    }

    @Override
    public void exit() throws SQLException {

        Logger logger = Logger.getLogger(EmpServiceImpl.class.getName());
        if (conn != null) conn.close();
        logger.info("Connection CLOSED");
        System.out.println("인사관리 시스템을 종료합니다.");
        System.exit(0);
    }

    @Override
    public void menu() throws SQLException, IOException {

        while (true) {
            System.out.print("인사관리 메뉴를 입력하세요.: ");
            switch (BR.readLine()) {
                case "0":
                    exit();
                    break;
                case "2":
                    System.out.println(selectAll());
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    return;
            }
        }
    }
}

