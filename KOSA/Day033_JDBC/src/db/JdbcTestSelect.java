package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTestSelect {

    public static void main(String args[]) throws SQLException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        conn = DBConnection.getConnection();

        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM emp");

            while (rset.next()) {
                System.out.print(rset.getInt(1) + " "); // empno
                System.out.println(rset.getString(2));  // ename
            }
        } finally {
            if (rset != null)
                rset.close();
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        }
    }
}