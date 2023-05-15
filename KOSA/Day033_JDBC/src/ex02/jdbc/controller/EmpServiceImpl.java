package ex02.jdbc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.logging.Logger;

public class EmpServiceImpl implements EmpService {

    private static final EmpService INSTANCE = new EmpServiceImpl("jdbc:oracle:thin:@127.0.0.1:1521:XE", "KOSA", "java");
    private static java.sql.Connection conn;
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
    public String selectByGno() {
        return null;
    }

    @Override
    public String selectAll() throws SQLException {
        StringBuilder sb = new StringBuilder();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
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
    public int insert(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int deptno) {
        return 0;
    }

    @Override
    public int update(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int deptno) {
        return 0;
    }

    @Override
    public int delete(int empno) {
        return 0;
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
        String menu;

        while (true) {
            System.out.print("인사관리 메뉴를 입력하세요.: ");
            menu = BR.readLine();

            switch (menu) {
                case "0":
                    exit();
                    break;
                case "2":
                    System.out.println(selectAll());
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}

