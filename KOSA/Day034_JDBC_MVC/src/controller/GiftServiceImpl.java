package controller;

import db_conn.util.CloseHelper;
import db_conn.util.ConnectionHelper;
import model.GiftDTO;

import java.io.*;
import java.sql.*;

public class GiftServiceImpl implements GiftService {

    private static final GiftService INSTANCE = new GiftServiceImpl();
    static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
    static Connection conn = null;
    static Statement stmt = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    private GiftServiceImpl() {
    }

    public static GiftService getInstance() {
        return INSTANCE;
    }

    @Override
    public void connect(String dsn, String uid, String pwd) {
        try {
            conn = ConnectionHelper.getConnection(dsn, uid, pwd);
            stmt = conn.createStatement();
            conn.setAutoCommit(false);  // 자동커밋 끄기
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        CloseHelper.close(rs);
        CloseHelper.close(stmt);
        CloseHelper.close(pstmt);
        CloseHelper.close(conn);
    }

    @Override
    public void menu() throws IOException, SQLException {
        GiftDTO dto = new GiftDTO();

        while (true) {
            System.out.println();
            ConnectionHelper.menu();
            switch (BR.readLine().trim()) {
                case "0":
                    System.out.print("COMMIT 하시겠습니까(Y/N)?");
                    if (BR.readLine().trim().equalsIgnoreCase("Y")) {
                        conn.commit();  // 예외 발생
                        selectAll(dto.getClassName());
                    } else {
                        conn.rollback();
                        selectAll(dto.getClassName());
                    }
                    break;
                case "1":
                    selectAll(dto.getClassName());
                    break;
                case "2":
                    insert(dto.getClassName());
                    selectAll(dto.getClassName());
                    break;
                case "3":
                    break;
                case "4":
                    delete(dto.getClassName());
                    break;
                case "5":
                    selectByGno(dto.getClassName());
                    break;
                case "6":
                    close();
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case "9":
                    conn.commit();
                    break;
                default:
                    break;
            }
        }
    }   // end menu()

    @Override
    public void selectAll(String className) throws SQLException, IOException {
        rs = stmt.executeQuery("SELECT * FROM " + className);   // 반환값 있는 경우

        ResultSetMetaData rsmd = rs.getMetaData();  // 해당 테이블에 대한 정보
        int cnt = rsmd.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= cnt; i++) { // 각 타입별로 출력하기
                switch (rsmd.getColumnType(i)) {
                    case Types.NUMERIC:
                    case Types.INTEGER:
                        BW.write(String.format("%s: %d%n", rsmd.getColumnName(i), rs.getInt(i)));
                        break;
                    case Types.FLOAT:
                        BW.write(String.format("%s: %d%n", rsmd.getColumnName(i), rs.getFloat(i)));
                        break;
                    case Types.DOUBLE:
                        BW.write(String.format("%s: %d%n", rsmd.getColumnName(i), rs.getDouble(i)));
                        break;
                    case Types.CHAR:
                        BW.write(String.format("%s: %s%n", rsmd.getColumnName(i), rs.getString(i)));
                        break;
                    case Types.DATE:
                        BW.write(String.format("%s: %s%n", rsmd.getColumnName(i), rs.getDate(i)));
                        break;
                    default:
                        BW.write(String.format("%s: %s%n", rsmd.getColumnName(i), rs.getString(i)));
                        break;
                }
            }
            BW.write("\n");
        }   // end while
        BW.flush();
    }   // end selectAll()

    @Override
    public void insert(String className) throws IOException {
        System.out.print("GNO: ");
        int gno = Integer.parseInt(BR.readLine());
        System.out.print("GNAME: ");
        String gname = BR.readLine();
        System.out.print("G_START: ");
        int g_start = Integer.parseInt(BR.readLine());
        System.out.print("G_END: ");
        int g_end = Integer.parseInt(BR.readLine());

        try {
            pstmt = conn.prepareStatement("INSERT INTO " + className + " VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, gno);
            pstmt.setString(2, gname);
            pstmt.setInt(3, g_start);
            pstmt.setInt(4, g_end);

            int res = pstmt.executeUpdate();
            System.out.printf("%d개 데이터가 추가되었습니다.", res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }   // end insert()

    @Override
    public void update() {

    }

    @Override
    public void delete(String className) throws IOException {
        System.out.print("GNO: ");
        int gno = Integer.parseInt(BR.readLine());

        try {
            pstmt = conn.prepareStatement("DELETE FROM " + className + " WHERE gno = ?");
            pstmt.setInt(1, gno);

            int res = pstmt.executeUpdate();
            System.out.printf("%d개 데이터가 삭제되었습니다.", res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }   // end delete()

    @Override
    public void selectByGno(String className) throws IOException {
        System.out.print("GNO: ");
        int gno = Integer.parseInt(BR.readLine());
        try {
            pstmt = conn.prepareStatement("SELECT * FROM " + className + " WHERE gno = ?");
            pstmt.setInt(1, gno);
            rs = pstmt.executeQuery();   // 반환값 있는 경우

            ResultSetMetaData rsmd = rs.getMetaData();  // 해당 테이블에 대한 정보
            int cnt = rsmd.getColumnCount();

            for (int i = 1; i <= cnt; i++) { // 각 타입별로 출력하기
                switch (rsmd.getColumnType(i)) {
                    case Types.NUMERIC:
                    case Types.INTEGER:
                        BW.write(String.format("%s: %d%n", rsmd.getColumnName(i), rs.getInt(i)));
                        break;
                    case Types.FLOAT:
                        BW.write(String.format("%s: %d%n", rsmd.getColumnName(i), rs.getFloat(i)));
                        break;
                    case Types.DOUBLE:
                        BW.write(String.format("%s: %d%n", rsmd.getColumnName(i), rs.getDouble(i)));
                        break;
                    case Types.CHAR:
                        BW.write(String.format("%s: %s%n", rsmd.getColumnName(i), rs.getString(i)));
                        break;
                    case Types.DATE:
                        BW.write(String.format("%s: %s%n", rsmd.getColumnName(i), rs.getDate(i)));
                        break;
                    default:
                        BW.write(String.format("%s: %s%n", rsmd.getColumnName(i), rs.getString(i)));
                        break;
                }
            }
            BW.write("\n");
            BW.flush();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
