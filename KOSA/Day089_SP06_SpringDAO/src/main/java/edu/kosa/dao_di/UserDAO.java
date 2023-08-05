package edu.kosa.dao_di;

import edu.kosa.model.UserVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserDAO {

    @Autowired
    private ConnectionMaker connectionMaker;    // has-a

    // 3. DML 명령어
    // INSERT
    public void insert(UserVO vo) throws Exception {
        Connection conn = connectionMaker.makeConnection();
        String sql = "INSERT INTO USERS(ID, NAME, PASSWORD) VALUES(?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, vo.getId());
        pstmt.setString(2, vo.getName());
        pstmt.setString(3, vo.getPassword());
        int result = pstmt.executeUpdate();
        System.out.println(result + "개 입력 성공!");

        pstmt.clearParameters();
        conn.close();
    } // End INSERT

    // SELECT_ALL
    public void selectAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;

        try {
            conn = connectionMaker.makeConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM USERS");

            System.out.println("\nID\tName\tPW");

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String pwd = rs.getString("password");
                System.out.println(id + "\t" + name + "\t" + pwd);
            }   // End while
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // SELECT_BY_ID
    public void selectByID(String id) throws Exception {
        Connection conn = connectionMaker.makeConnection();
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            String pwd = rs.getString("password");
            System.out.println(id + "\t" + name + "\t" + pwd);
        } else {
            System.out.println("ID에 해당하는 데이터가 존재하지 않습니다.");
        }
        pstmt.clearParameters();
        conn.close();
    }

    // UPDATE
    public void update(UserVO vo) throws Exception {
        Connection conn = connectionMaker.makeConnection();
        String sql = "UPDATE USERS SET NAME = ?, PASSWORD = ? WHERE ID = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getName());
        pstmt.setString(2, vo.getPassword());
        pstmt.setString(3, vo.getId());
        int result = pstmt.executeUpdate();
        System.out.println(result + "개 수정 성공!");
        pstmt.clearParameters();
        conn.close();
    }

    // DELETE
    public void delete(String id) throws Exception {
        Connection conn = connectionMaker.makeConnection();
        String sql = "DELETE FROM USERS WHERE ID = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        int result = pstmt.executeUpdate();
        System.out.println(result + "개 삭제 성공");
        pstmt.clearParameters();
        conn.close();
    }

    // menu
    public void menu() {
        System.out.println("선택하세요.:");
        System.out.println("1. INSERT\n2. SELECT ALL\n3. SELECT BY ID\n4. UPDATE\n5. DELETE");
    }
}
