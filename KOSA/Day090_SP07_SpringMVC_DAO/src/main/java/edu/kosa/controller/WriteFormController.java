package edu.kosa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WriteFormController {

    @GetMapping(value = "/writeform")
    public String writeform(Model model) {

        return "writeform";
    }
}
