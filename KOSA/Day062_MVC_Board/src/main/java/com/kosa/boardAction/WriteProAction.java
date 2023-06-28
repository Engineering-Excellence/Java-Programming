package com.kosa.boardAction;

import com.kosa.boardModel.BoardDAO;
import com.kosa.boardModel.BoardDAOImpl;
import com.kosa.boardModel.BoardVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WriteProAction implements CommandAction {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("process()");

        request.setCharacterEncoding("UTF-8");

        BoardVO vo = new BoardVO();
        vo.setNum(Integer.parseInt(request.getParameter("num")));
        vo.setWriter(request.getParameter("name"));
        vo.setSubject(request.getParameter("subject"));
        vo.setEmail(request.getParameter("email"));
        vo.setContent(request.getParameter("content"));
        vo.setPasswd(request.getParameter("passwd"));
        vo.setReg_date(new Timestamp(System.currentTimeMillis()));
        vo.setRef(Integer.parseInt(request.getParameter("ref")));
        vo.setRe_step(Integer.parseInt(request.getParameter("re_step")));
        vo.setRe_level(Integer.parseInt(request.getParameter("re_level")));
        vo.setIp(request.getRemoteAddr());

        BoardDAO dao = BoardDAOImpl.getInstance();
        dao.insert(vo);

        return "/board/writePro.jsp";
    }
}
