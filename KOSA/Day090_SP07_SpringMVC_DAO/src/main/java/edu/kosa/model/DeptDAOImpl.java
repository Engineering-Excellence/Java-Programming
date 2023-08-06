package edu.kosa.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class DeptDAOImpl implements DeptDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;  // DML 명령 처리 클래스 (insert, update, delete 등등..)

    @Override
    public List listDept() {
        // select
        String sql = "SELECT * FROM DEPT ORDER BY DEPTNO DESC";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public void insertDept(DeptDTO dto) {
        // insert
        String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
        Object[] obj = {dto.getDeptNo(), dto.getDName(), dto.getLoc()};
        jdbcTemplate.update(sql, obj);
    }
}
