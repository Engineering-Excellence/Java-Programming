package kr.or.sw.controller;

import kr.or.sw.service.GiftService;
import kr.or.sw.service.GiftServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "Gift", value = "/gift/*")
public class FrontController extends HttpServlet {

    private static final long serialVersionUID = -1847552111947512469L;

    private GiftService giftService = GiftServiceImpl.getInstance();

    private static final String REDIRECT_PATH = "/index.jsp?redirect=true";
    private static final String VIEW_PATH = "/WEB-INF/views/giftOK.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet()");

        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "/index":
                log.info("/index");
                redirectToIndex(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost()");

        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "/register":
                log.info("register");
                boolean register = giftService.register(request, response);
                if (register) log.info("상품 등록 완료");
                break;
            case "/search":
                log.info("search");
                int match = giftService.search(request, response);
                log.info("{}개 상품 일치", match);
                break;
            default:
                handleInvalidAccess(response, pathInfo);
                break;
        }
    }

    private void redirectToIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("redirectToIndex()");

        response.sendRedirect(request.getContextPath() + REDIRECT_PATH);
    }

    private void handleInvalidAccess(HttpServletResponse response, String pathInfo) throws ServletException, IOException {
        log.info("handleInvalidAccess()");

        log.error("잘못된 접근 : {}", pathInfo);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        response.getWriter().write("{ \"message\": \"FORBIDDEN\" }");
//        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
}
