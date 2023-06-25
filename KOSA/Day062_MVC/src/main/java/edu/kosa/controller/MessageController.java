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
@WebServlet(name = "messageController", value = "/mc")
public class MessageController extends HttpServlet {
    // 1. 전송방식 결정
    // 2. 사용자 요청 분석(doGet/doPost)

    private static final long serialVersionUID = -2718939742189574815L;

    @Override
    public void init() {
        log.info("init()");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet()");

        String msg = request.getParameter("msg");
        String daebo = "대보 2기 전원 입사";
        Object result = null;
        switch (msg) {
            case "":
            case "test":
                result = "메시지가 없거나, test로 넘어왔습니다.";
                break;
            case "name":
                result = "내 이름은 Kyle.";
                break;
            case "aa":
                result = "Is your name aa?";
                break;
            default:
                result = "찾는 type이 없습니다.";
                break;
        }

        // 3. 저장 - req.setAttribute("변수", 값)
        request.setAttribute("result", result);
        request.setAttribute("str", daebo);
        request.setAttribute("message", "반가워요.");

        // 4. 이동할 뷰 페이지 지정
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/messageView.jsp");    // view page
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        log.info("doPost()");
    }

    @Override
    public void destroy() {
        log.info("destroy()");
    }
}