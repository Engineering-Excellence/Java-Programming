package kr.edu.kosa;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class ListController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        log.info("move to list.jsp");

        ModelAndView mv = new ModelAndView();

        mv.addObject("list", "List Page");
        mv.addObject("title", "Title");
        mv.addObject("content", "Content");

        mv.setViewName("list");

        return mv;
    }
}
