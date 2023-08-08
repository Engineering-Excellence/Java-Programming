package com.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public MemberVO selectMemberById(String id) {   // 특정 id로 검색
        String sql = "SELECT * FROM USERMEMBER WHERE ID = ?";
        return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(MemberVO.class), id);
    }

    @Override
    public List<MemberVO> selectAllMembers() {
        String sql = "SELECT * FROM USERMEMBER";
        return this.jdbcTemplate.query(sql, (rs, rowNum) -> new MemberVO(rs.getString("ID"), rs.getString("NAME"), rs.getString("PWD"), rs.getString("EMAIL"), rs.getInt("AGE")));
    }

    @Override
    public boolean memberCheck(String id, String pwd) {
        String sql = "SELECT * FROM USERMEMBER WHERE ID = ? AND PWD = ?";
        Object[] params = {id, pwd};
        return this.jdbcTemplate.queryForList(sql, params).size() == 1;
    }

    @Override
    public boolean memberInsert(MemberVO member) {
        String sql = "INSERT INTO USERMEMBER (id, name, pwd, email, age) VALUES (?, ?, ?, ?, ?)";
        Object[] params = {member.getId(), member.getName(), member.getPwd(), member.getEmail(), member.getAge()};
        return this.jdbcTemplate.update(sql, params) > 0;
    }
}
