package com.controller;

import com.model.MemberDAO;
import com.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = {"/join.kosa"})
public class JoinController {

    @Autowired
    private MemberDAO memberDAO;    // DB

    @GetMapping
    public String form() {

        return "joinForm";
    }

    @PostMapping
    public String submit(@RequestParam(value = "id") String id,
                         @RequestParam(value = "pwd") String pwd,
                         @RequestParam(value = "name") String name,
                         @RequestParam(value = "age") int age,
                         @RequestParam(value = "email") String email) {

        String viewPage;
        MemberVO member = new MemberVO(id, name, pwd, email, age);
        boolean joinMember = memberDAO.memberInsert(member);
        if (joinMember) viewPage = "redirect:/login.kosa";
        else viewPage = "joinForm";

        return viewPage;
    }
}
