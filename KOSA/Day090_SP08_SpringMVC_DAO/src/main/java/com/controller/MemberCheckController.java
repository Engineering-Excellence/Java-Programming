package com.controller;

import com.model.MemberDAO;
import com.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/check.kosa")
public class MemberCheckController {

    @Autowired
    private MemberDAO memberDAO;

    @GetMapping
    public String form() {
        return "memberCheckForm";
    }

    @PostMapping
    public ModelAndView submit(@RequestParam(value = "id") String id) {

        ModelAndView mav = new ModelAndView();
        MemberVO vo = memberDAO.selectMemberById(id);
        List<MemberVO> list = memberDAO.selectAllMembers();
        mav.addObject("memberOK", list);

        if (!list.isEmpty()) {
            mav.setViewName("memberCheckSuccess");
        } else {
            mav.setViewName("memberCheckForm");
        }
        return mav;
    }
}
