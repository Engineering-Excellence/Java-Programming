package com.javassem.dao;

import com.javassem.domain.ReplyVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("replyDAO")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReplyDAOImpl implements ReplyDAO {

    private final SqlSessionTemplate mybatis;

    public Integer insertReply(ReplyVO vo) {
        System.out.println("===> Mybatis insertReply() 호출");
        return mybatis.insert("ReplyDAO.insertReply", vo);
    }

    public List<ReplyVO> selectAllReply() {
        System.out.println("===> Mybatis selectAllReply() 호출");
        return mybatis.selectList("ReplyDAO.selectAllReply");
    }

    @Override
    public int deleteReply(int rno) {
        System.out.println("===> Mybatis deleteReply() 호출");
        return mybatis.delete("ReplyDAO.deleteReply", rno);
    }
}
