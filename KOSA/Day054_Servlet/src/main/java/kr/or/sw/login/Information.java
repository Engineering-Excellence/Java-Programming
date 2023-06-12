package kr.or.sw.login;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet(name = "info", value = "/info", loadOnStartup = 1, asyncSupported = true)
public class Information extends HttpServlet {

    private static final long serialVersionUID = -3319011977047975184L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost()");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html lang='ko'><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'/><title>Login Result</title></head><body>");
        out.println("<h1>이름: " + name + "</h1>");
        out.println("<h1>연락처: " + contact + "</h1>");
        out.println("<h1>주소: " + address + "</h1>");
        out.println("<a href='jsp/info.jsp'>Info Input Window</a>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        super.destroy();
        log.info("destroy()");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        log.info("init()");
    }
}
