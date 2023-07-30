package kr.edu.kosa.controller;

import kr.edu.kosa.model.InfoVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class InfoController {

    private final InfoVO infoVO;

    @GetMapping(value = {"/info"})
    public String info(Model model) {

        // 이름, 주소, 연락처 데이터 출력하기
        model.addAttribute("infoVO", infoVO);

        return "info";
    }
}
