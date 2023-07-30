package kr.edu.kosa.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Log4j2
@Controller
public class HomeController {

    @GetMapping(value = {"/"})
    public String home(Locale locale, Model model) {

        log.info("/home");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);    // request.setAttribute("serverTime", formattedDate);
        model.addAttribute("name", "Kyle");
        model.addAttribute("age", 99);

        return "home";  // /WEB-INF/views/home.jsp
//        return "main";  // /WEB-INF/jsp/main.jsp
    }
}
