package com.javassem.service;

import com.javassem.dao.ReplyDAO;
import com.javassem.domain.ReplyVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service("replyService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReplyServiceImpl {

    private final ReplyDAO replyDAO;

    public Integer insertReply(ReplyVO vo) {
        log.info("insertReply({})", vo);
        return replyDAO.insertReply(vo);
    }

    public List<ReplyVO> selectAllReply() {
        return replyDAO.selectAllReply();
    }

    public int deleteReply(int rno) {
        return replyDAO.deleteReply(rno);
    }
}
