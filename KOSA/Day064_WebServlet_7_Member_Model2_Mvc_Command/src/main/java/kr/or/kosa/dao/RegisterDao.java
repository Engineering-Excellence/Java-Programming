package kr.or.kosa.dao;

import kr.or.kosa.dto.RegisterDto;
import kr.or.kosa.utils.ConnectionHelper;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.List;
import java.util.Vector;

/*
1. DB연결 POOL
2. insert 작업 
insert into mvcregister(id,pwd,email) values(?,?,?)

*/
@Slf4j
public class RegisterDao {

    //writeOk ...
    //insert into mvcregister(id,pwd,email) values(?,?,?)
    public int writeOk(RegisterDto dto) {
        log.info("writeOk()");

        Connection conn = null;
        PreparedStatement pstmt = null;
        int resultrow = 0;
        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "INSERT INTO MVCREGISTER(ID,PWD,EMAIL) VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getPwd());
            pstmt.setString(3, dto.getEmail());

            resultrow = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        } finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return resultrow;
    }

    public List<RegisterDto> selectAll() {
        log.info("selectAll()");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        List<RegisterDto> list = null;
        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "SELECT * FROM MVCREGISTER";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            list = new Vector<>();
            while (rs.next()) {
                RegisterDto dto = new RegisterDto();
                dto.setId(rs.getInt("id"));
                dto.setPwd(rs.getString("pwd"));
                dto.setEmail(rs.getString("email"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        } finally {
            ConnectionHelper.close(stmt);
            ConnectionHelper.close(conn);
        }
        return list;
    }
}
