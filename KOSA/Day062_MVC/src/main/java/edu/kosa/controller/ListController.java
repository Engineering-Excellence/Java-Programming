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
@WebServlet(name = "ListController", value = "/list")
public class ListController extends HttpServlet implements CommandProcess {

    private static final long serialVersionUID = 4754962083087449706L;

    @Override
    public String doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doProcess()");

        request.setAttribute("list", "List Page입니다.");
        return "/board/list.jsp";
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
    }

    @Override
    public void init() throws ServletException {
        log.info("init()");
    }

    @Override
    public void destroy() {
        log.info("destroy()");
    }
}
