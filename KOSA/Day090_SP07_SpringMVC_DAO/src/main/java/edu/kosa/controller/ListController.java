package edu.kosa.controller;

import edu.kosa.model.DeptDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

@Controller
public class ListController {

    @Autowired
    private DeptDAO deptDAO;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", deptDAO.listDept());
        return "list";
    }

    @RequestMapping("/hello")
    public ModelAndView hello() {
        ModelAndView ret = new ModelAndView();
        ret.addObject("message", getGreeting());
        ret.setViewName("hello");
        return ret;
    }

    public Object getGreeting() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour <= 11) return "Good Morning";
        else if (hour > 11 && hour <= 17) return "Good Afternoon";
        else if (hour > 17 && hour <= 21) return "Good Evening";
        else return "Good Night";
    }
}
