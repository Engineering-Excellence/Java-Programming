package com.javassem.dao;

import com.javassem.domain.ReplyVO;

import java.util.List;

public interface ReplyDAO {

    Integer insertReply(ReplyVO vo);

    List<ReplyVO> selectAllReply();

    int deleteReply(String rno);
}
