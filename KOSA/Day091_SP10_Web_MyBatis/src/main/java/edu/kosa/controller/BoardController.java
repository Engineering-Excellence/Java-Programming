package edu.kosa.controller;

import edu.kosa.model.BoardVO;
import edu.kosa.service.CRUDService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class BoardController {

    private final CRUDService service;

    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("boardList", service.selectAll());
        return "list";
    }

    @GetMapping("writeForm")
    public String writeForm() {
        return "writeForm";
    }

    @PostMapping("write")
    public String write(@ModelAttribute final BoardVO boardVO) {
        if (service.insert(boardVO)) log.info("신규 글 작성 성공");
        return "redirect:/board/list";
    }

    @GetMapping("detail/{seq}")
    public String detail(Model model, @PathVariable("seq") final int seq) {
        model.addAttribute("boardVO", service.select(seq));
        return "detail";
    }

    @PostMapping("update")
    public String update(@ModelAttribute final BoardVO boardVO) {
        if (service.update(boardVO)) log.info("{}번 글 수정 성공", boardVO.getSeq());
        return "redirect:/board/detail/" + boardVO.getSeq();
    }

    @GetMapping("delete/{seq}")
    public String delete(@PathVariable("seq") final int seq) {
        if (service.delete(seq)) log.info("{}번 글 삭제 성공", seq);
        return "redirect:/board/list";
    }

    @GetMapping("search")
    public String searchList() {
        return "searchList";
    }

    @PostMapping("search")
    public String selectSearch(Model model, @ModelAttribute final BoardVO boardVO) {
        log.info("condition: {}, keyword: {}", boardVO.getCondition(), boardVO.getKeyword());
        model.addAttribute("searchResult", service.search(boardVO));
        return "searchList";
    }
}
