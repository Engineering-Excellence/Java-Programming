package com.javassem.controller;

import com.javassem.domain.SampleVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/sample")
public class SampleController {

    // 1. 문자열 반환
    @GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
    public String getTest() {
        return "컨트롤러로부터";
    }

    // 2. 객체 반환
    @GetMapping(value = "/getObject")
    public SampleVO getObject() {
        return new SampleVO("Kyle", 99, "RESTful 테스트");
    }

    @GetMapping(value = "/getModel")
    public SampleVO getModel(Model model) {
        SampleVO vo = new SampleVO("Kyle", 99, "RESTful 테스트");
        model.addAttribute("vo", vo);
        return vo;
    }

    // 3. 리스트 객체 반환
    @GetMapping(value = "/getList")
    public List<SampleVO> getList() {
        List<SampleVO> list = new ArrayList<>();
        list.add(new SampleVO("anonym", 11, "RESTful 테스트1"));
        list.add(new SampleVO("Kong", 22, "RESTful 테스트2"));
        list.add(new SampleVO("Kaiser", 33, "RESTful 테스트3"));
        return list;
    }

    // 4. URL에서 정보 얻기(ex: /sample/{category}/{cno})
    @GetMapping(value = "/{category}/{cno}")
    public String[] getPath(@PathVariable String category, @PathVariable int cno) {
        return new String[]{"카테고리: " + category, "번호: " + cno};
    }

    // 5. POST 전송
    @PostMapping(value = "/data")
    public SampleVO post(@ModelAttribute SampleVO vo) {
        log.info("vo = {}", vo);
        return vo;
    }
}
