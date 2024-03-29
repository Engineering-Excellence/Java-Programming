package com.tjoeun.memoList;

import java.sql.*;

public class DBUtil {

    //	MySQL에 연결하는 Connection을 만들어 리턴하는 메소드
    public static Connection getMySQLConnection() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 5.x
//			Class.forName("com.mysql.cj.jdbc.Driver"); // 8.x
            String url = "jdbc:mysql://localhost:3306/javaam?useUnicode=true&characterEncoding=UTF-8"; // 5.x
//			String url = "jdbc:mysql://localhost:3306/javaam?serverTimezone=UTC"; // 8.x
            conn = DriverManager.getConnection(url, "root", "0000");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
        }
        return conn;
    }

    //	데이터베이스 작업에 사용한 객체를 닫는 메소드
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
