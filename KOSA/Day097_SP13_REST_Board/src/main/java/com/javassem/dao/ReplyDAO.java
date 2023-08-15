package com.javassem.dao;

import com.javassem.domain.ReplyVO;

import java.util.List;

public interface ReplyDAO {

    public Integer insertReply(ReplyVO vo);

    public List<ReplyVO> selectAllReply();

    public int deleteReply(int rno);
}
