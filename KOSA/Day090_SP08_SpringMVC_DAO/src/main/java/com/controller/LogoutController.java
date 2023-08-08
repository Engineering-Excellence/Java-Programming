package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @PostMapping(value = "/logout.kosa")
    public String logout(HttpSession session) {

        session.invalidate();   // 세션 정보 종료

        return "loginForm";
    }
}
