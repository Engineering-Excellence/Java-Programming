package edu.kosa.controller;

import edu.kosa.model.BoardDTO;
import edu.kosa.model.BoardList;
import edu.kosa.service.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BoardController {

    private final CRUDService service;
    private final BoardList boardList;

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("list")
    public String list(Model model,
                       @RequestParam(required = false, defaultValue = "1") int page) {

    /*
        int start = page * rowSieze - (rowSieze - 1);
        int end = page * rowSieze;

        int fromPage = ((page - 1) / block * block) + 1; // 시작 페이지
        int toPage = ((page - 1) / block * block) + block;  // 종료 페이지

        int totalCount = service.count();
        int allPage = (int) Math.ceil(totalCount / (double) rowSieze);   // 페이지 수

        if (toPage > allPage) {
            toPage = allPage;
        }
    */

        boardList.initBoardList(boardList.getPageSize(), service.count(), page);

        Map<String, Integer> map = new HashMap<>();
        map.put("start", boardList.getStartNo());
        map.put("end", boardList.getEndNo());

        model.addAttribute("list", service.readAll(map));
        model.addAttribute("page", page);
        model.addAttribute("allPage", boardList.getTotalPage());
        model.addAttribute("block", boardList.getBLOCK());  // 한 페이지에 보여줄 범위
        model.addAttribute("fromPage", boardList.getStartPage());
        model.addAttribute("toPage", boardList.getEndPage());

        return "list";
    }

    @GetMapping("read/{num}")
    public String read(Model model,
                       @PathVariable int num,
                       @RequestParam(required = false, defaultValue = "1") int page) {

        service.hit(num);
        model.addAttribute("boardDTO", service.read(num));
        model.addAttribute("page", page);
        return "read";
    }

    @GetMapping("writeForm")
    public String writeForm(Model model,
                            @RequestParam(required = false, defaultValue = "1") int page) {

        model.addAttribute("page", page);
        return "writeForm";
    }

    @PostMapping("write")
    public String write(Model model,
                        @RequestParam(required = false, defaultValue = "1") int page,
                        @ModelAttribute BoardDTO boardDTO) {

        model.addAttribute("page", page);
        service.create(boardDTO);
        return "redirect:/list";
    }

    @GetMapping("updateForm/{num}")
    public String updateForm(Model model,
                             @PathVariable int num,
                             @RequestParam(required = false, defaultValue = "1") int page) {

        model.addAttribute("boardDTO", service.read(num));
        model.addAttribute("page", page);
        return "updateForm";
    }

    @PostMapping("update")
    public String update(Model model,
                         @ModelAttribute BoardDTO boardDTO,
                         @RequestParam(required = false, defaultValue = "1") int page) {

        model.addAttribute("page", page);
        return service.update(boardDTO) ? "redirect:/list?" + page : "fail";
    }

    @GetMapping("deleteForm/{num}")
    public String delete(Model model,
                         @PathVariable int num,
                         @RequestParam(required = false, defaultValue = "1") int page) {

        model.addAttribute("boardDTO", service.read(num));
        model.addAttribute("page", page);
        return "deleteForm";
    }

    @PostMapping("delete")
    public String delete(Model model,
                         @ModelAttribute BoardDTO boardDTO,
                         @RequestParam(required = false, defaultValue = "1") int page) {

        model.addAttribute("page", page);
        return service.delete(boardDTO) ? "redirect:/list?" + page : "fail";
    }

    @GetMapping("replyForm/{num}")
    public String replyForm(Model model,
                            @PathVariable int num,
                            @RequestParam(required = false, defaultValue = "1") int page) {

        model.addAttribute("boardDTO", service.read(num));
        model.addAttribute("page", page);
        return "replyForm";
    }

    @PostMapping("reply")
    public String reply(Model model,
                        @ModelAttribute BoardDTO boardDTO,
                        @RequestParam(required = false, defaultValue = "1") int page) {

        boardDTO.setSort(boardDTO.getSort() + 1);   // 답글이 들어갔는지 확인
        boardDTO.setTab(boardDTO.getTab() + 1); // 밀어쓰기
        service.updateSort(boardDTO);
        service.reply(boardDTO);
        model.addAttribute("page", page);
        return "redirect:/list?" + page;
    }
}
