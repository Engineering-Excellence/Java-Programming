package com.javassem.controller;

import com.javassem.domain.ReplyVO;
import com.javassem.service.ReplyServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReplyController {

    private final ReplyServiceImpl replyService;

    @GetMapping("/list")
    public List<ReplyVO> list() {
        return replyService.selectAllReply();
    }

    @PostMapping("/insert")
    public void insert(@RequestBody ReplyVO vo) {
        log.info("insert({})", vo);
        replyService.insertReply(vo);
    }

    @PutMapping("/update")
    public void update(@RequestBody ReplyVO vo) {
//        replyService.updateReply(vo);
    }

    @DeleteMapping("/delete/{rno}")
    public void delete(@PathVariable int rno) {
        replyService.deleteReply(rno);
    }
}
