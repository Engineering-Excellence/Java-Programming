package kr.edu.kosa;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class WriteController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        log.info("move to write.jsp");

        ModelAndView mv = new ModelAndView();
        mv.addObject("author", httpServletRequest.getParameter("author"));
        mv.addObject("title", httpServletRequest.getParameter("title"));
        mv.addObject("content", httpServletRequest.getParameter("content"));
        mv.setViewName("write");

        return mv;
    }
}
