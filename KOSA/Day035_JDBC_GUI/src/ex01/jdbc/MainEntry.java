package ex01.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.ConnectionHelper;

public class MainEntry {

  public static void main(String[] args) {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      conn = ConnectionHelper.getConnection("ORACLE");
      conn.setAutoCommit(false);
      stmt = conn.createStatement();
      // SQL 구문, HTML Tag는 Java/JSP/Servlet에서 문자열 취급한다.
      String sql = "CREATE TABLE kosadb (name VARCHAR2(20), age NUMBER)";
      stmt.executeUpdate(sql); // 반환값이 없는 경우

      sql = "INSERT INTO kosadb VALUES ('YUNA', 33)";
      int result = stmt.executeUpdate(sql);

      sql = "SELECT * FROM kosadb";
      rs = stmt.executeQuery(sql); // 반환값이 있는 경우
      System.out.println(result + "개 추가 됨");

      while (rs.next()) {
        System.out.println("name: " + rs.getString(1) + "\t");
        System.out.println("age: " + rs.getInt("age"));
      }
      //            conn.commit();
      //            conn.rollback();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
          stmt.close();
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
