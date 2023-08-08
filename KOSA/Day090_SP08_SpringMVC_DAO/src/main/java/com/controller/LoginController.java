package com.controller;

import com.model.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login.kosa")
public class LoginController {

    @Autowired
    private MemberDAO memberDAO;

    @GetMapping
    public String form() {
        return "loginForm";
    }

    @PostMapping
    public String submit(@RequestParam(value = "id") String id,
                         @RequestParam(value = "pwd") String pwd,
                         HttpSession session) {

        String viewPage;

        if (memberDAO.memberCheck(id, pwd)) {
            session.setAttribute("userID", id);
            viewPage = "loginSuccess";
        } else {
            viewPage = "loginForm";
        }

        return viewPage;
    }
}
