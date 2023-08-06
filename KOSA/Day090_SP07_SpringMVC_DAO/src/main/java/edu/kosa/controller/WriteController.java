package edu.kosa.controller;

import edu.kosa.model.DeptDAO;
import edu.kosa.model.DeptDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
public class WriteController {

    @Autowired
    private DeptDAO deptDAO;

    @PostMapping(value = "/write")
    public String write(Model model,
                        @RequestParam(value = "deptno") int deptno,
                        @RequestParam(value = "deptname") String deptname,
                        @RequestParam(value = "deptloc") String deptloc) {

        log.info("deptno {}, deptname {}, deptloc {}", deptno, deptname, deptloc);
        deptDAO.insertDept(new DeptDTO(deptno, deptname, deptloc));

        return "redirect:/list";
    }
}
