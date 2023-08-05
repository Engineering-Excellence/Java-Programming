package kr.edu.kosa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // ModelAndView: 데이터 저장, 이동할 뷰페이지 등록
        log.info("move to hello.jsp");

        // 1.
        ModelAndView mv = new ModelAndView();
        mv.addObject("nickname", "Kaiser"); // Data Save
        mv.setViewName("hello");// Move to View Page

        return mv;
    }
}
