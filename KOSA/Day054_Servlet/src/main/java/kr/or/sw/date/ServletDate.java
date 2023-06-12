package kr.or.sw.date;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Slf4j
public class ServletDate extends HttpServlet {

    private static final long serialVersionUID = -450446211709516988L;

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Hello, Servlet!");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("ServletDate");

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        PrintWriter out = response.getWriter();
        out.write("<!DOCTYPE html><html lang='ko'><head><title>서버 측 시간</title></head>");
        out.write("<body><h1>Hello Servlet</h1>");
        out.write("<h2>Server Time: ");
        out.write(hour + "시 ");
        out.write(minute + "분 ");
        out.write(second + "초");
        out.write("</h2></body></html>");
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}
