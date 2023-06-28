package kr.or.kosa.controller;

import kr.or.kosa.service.MemoService;
import kr.or.kosa.service.MemoServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "MemoController", value = "/memo/*")
public class MemoController extends HttpServlet {

    private static final long serialVersionUID = 3721184651743490527L;
    private final MemoService memoService = MemoServiceImpl.getInstance();
    private static final String REDIRECT_PATH = "/index.html?redirect=true";
    private static final String LIST_PATH = "/WEB-INF/views/memoList.jsp";

    @Override
    public void init() {
        log.info("init()");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.info("doGet()");
        // 1. 한글 처리
        // 2. 데이터 받기
        // 3. DB 연결
        // 4. insert 실행
        // 5. 응답 구성

        request.setCharacterEncoding("UTF-8");
        /*response.setContentType("text/html; charset=UTF-8");    // 클라이언트에게 전달할 페이지의 정보 구성
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String content = request.getParameter("content");
        out.print(String.format("id: %s, email: %s, content: %s", id, email, content));
        out.flush();
        out.close();*/

        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "/index":
                log.info("/index"); // 인덱스(메모 작성) 화면으로 이동
                redirectToIndex(request, response);
                break;
            case "/list":
                log.info("/list");
                memoService.seletcAll(request, response);
                request.getRequestDispatcher(LIST_PATH).forward(request, response);
                break;
            case "/memo":
                log.info("/memo");
                memoService.selectOne(request, response);
                request.getRequestDispatcher("/WEB-INF/views/memo.jsp").forward(request, response);
                break;
            case "/id":
                log.info("/id");
                memoService.idCheck(request, response);
                request.getRequestDispatcher("/WEB-INF/views/check.jsp").forward(request, response);
                break;
            case "/delete":
                log.info("/delete");
                if (memoService.delete(request, response)) {
                    log.info("메모 삭제 성공");
                    request.getRequestDispatcher(LIST_PATH).forward(request, response);
                } else {
                    log.error("메모 삭제 실패");
                    redirectToIndex(request, response);
                }
                break;
            case "/update":
                log.info("/update");
                memoService.selectOne(request, response);
                request.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(request, response);
                break;
            default:
                handleInvalidAccess(response, pathInfo);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost()");

        request.setCharacterEncoding("UTF-8");
        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "/insert":
                log.info("/insert"); // 로그인
                if (memoService.insert(request, response)) {
                    log.info("메모 작성 성공");
                    request.getRequestDispatcher(LIST_PATH).forward(request, response);
                } else {
                    log.error("메모 작성 실패");
                    redirectToIndex(request, response);
                }
                break;
            case "/update":
                log.info("/update");
                if (memoService.update(request, response)) {
                    log.info("메모 수정 성공");
                    request.getRequestDispatcher(LIST_PATH).forward(request, response);
                } else {
                    log.error("메모 수정 실패");
                    redirectToIndex(request, response);
                }
                break;
            default:
                handleInvalidAccess(response, pathInfo);
                break;
        }
    }

    @Override
    public void destroy() {
        log.info("destroy()");
    }

    private void redirectToIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("redirectToIndex()");  // 인덱스(메모 작성) 화면으로 이동

        response.sendRedirect(request.getContextPath() + REDIRECT_PATH);
    }

    private void handleInvalidAccess(HttpServletResponse response, String pathInfo) throws ServletException, IOException {
        log.info("handleInvalidAccess()");  // 잘못된 접근 처리

        log.error("잘못된 접근 : {}", pathInfo);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        response.getWriter().write("{ \"message\": \"FORBIDDEN\" }");
//        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
}