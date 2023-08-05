package com.kosa;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Log4j2
@Controller
public class UpdateController {

    //    @GetMapping("/update.bo")
    @RequestMapping(value = {"/update.bo"}, method = RequestMethod.GET)
    public String update(Model model) {
        log.info("move to update.jsp");

        String name = "Kyle";

        model.addAttribute("name", name);
        model.addAttribute("update", "Update Page입니다.");

        return "update";
    }
}
