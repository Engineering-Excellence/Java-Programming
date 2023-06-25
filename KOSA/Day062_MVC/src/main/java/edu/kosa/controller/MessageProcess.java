package edu.kosa.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "MessageProcess", value = "/kosa")
public class MessageProcess extends HttpServlet implements CommandProcess {

    private static final long serialVersionUID = 2849151080496228675L;

    @Override
    public String doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doProcess()");

        // 저장 - 자신의 이름, 연락처
        request.setAttribute("message", "MVC 기반의 데이터 전송");

        // 이동할 뷰 페이지
        return "views/message.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet()");

        RequestDispatcher dispatcher = req.getRequestDispatcher(doProcess(req, resp));
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doPost()");

        doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
    }
}
