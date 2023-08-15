package com.javassem.controller;

import com.javassem.domain.SampleVO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sample")
public class SampleController {

    //1. 문자열 반환
//    @ResponseBody
    @GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
    public String getTest() {
        return "컨트롤러에서 보냈어요!";
    }

    //2. 객체 반환
    @GetMapping("/getObject")
    public SampleVO getObject(Model model) {
        SampleVO vo = new SampleVO("김연아", 33, "우리는 지금 레스트 테스트", "010-1234-5678", "ABC");
        model.addAttribute("vo", vo);
        return vo;
    }

    //3. 리스트 객체 반환
    @GetMapping("/getList")
    public List<SampleVO> getList() {
        List<SampleVO> list = new ArrayList<>();
        list.add(new SampleVO("김연아", 33, "우리는 지금 레스트 테스트", "010-1234-5678", "PIN"));
        list.add(new SampleVO("박태환", 22, "수영선수", "010-1234-5678", "PIN"));
        list.add(new SampleVO("세종대왕", 7, "한글창제", "010-1234-5678", "PIN"));
        return list;
    }

    //4. URL 에서 정보 얻기 /sample/{cate}/{no}
    @GetMapping(value = "/{cate}/{cno}")
//    public String[] getPath(String cate, Integer cno){
    public String[] getPath(@PathVariable String cate, @PathVariable Integer cno) {
        return new String[]{"카테고리 : " + cate, "번호:" + cno};
    }

    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam String name,
                             @RequestParam int age,
                             @RequestParam String message,
                             @RequestParam String phoneNumber) {
        return String.format("name: %s, age: %d, message: %s, phoneNumber: %s", name, age, message, phoneNumber);
    }

    @GetMapping(path = "query-param2")
    public String queryParam2(SampleVO dto) {
        // 객체 타입으로 리턴할 때는 @RequestParam 안 쓴다. 권장하는 방식.
        return dto.toString();
    }

    @PostMapping(value = "/data")
    public SampleVO post(@RequestBody SampleVO vo) {
        System.out.println(vo);
        System.out.println("[확인]");
        return vo;
    }

    @PostMapping(value = "/post")
    public void postSample(@RequestBody Map<String, Object> vo) {

        vo.forEach((key, value) -> {
            System.out.println("key: " + key);
            System.out.println("value: " + value);
        });
    }

    @DeleteMapping(value = "/delete/{name}")
    public void delete(@PathVariable String name) {
        System.out.println(name);
    }

    @PutMapping(value = "/put-name/{name}")
    public SampleVO  put(@RequestBody SampleVO dto,
                         @PathVariable(name = "name") String irum) {
        System.out.println(irum);
        System.out.println(dto);
        return dto;
    }
}
