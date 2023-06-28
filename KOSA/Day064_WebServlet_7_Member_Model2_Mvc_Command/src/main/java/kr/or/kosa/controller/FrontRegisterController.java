package kr.or.kosa.controller;

import kr.or.kosa.dao.RegisterDao;
import kr.or.kosa.dto.RegisterDto;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
http://192.168.0.29:8090/WebSite/list.do >> *.do 매핑
http://192.168.0.29:8090/WebSite/write.do >> *.do 매핑
http://192.168.0.29:8090/WebSite/update.do >> *.do 매핑
@WebServlet("*.do")
방식은 url 방식활용

command 방식에서도 가능
@WebServlet("/servlet.do")
http://192.168.0.29:8090/WebSite/servlet.do?cmd=list
http://192.168.0.29:8090/WebSite/servlet.do?cmd=write
http://192.168.0.29:8090/WebSite/servlet.do?cmd=update
*/
@Slf4j
@WebServlet("*.do")
public class FrontRegisterController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doProcess()");

        //1. 한글
        request.setCharacterEncoding("UTF-8");
        //2. 데이터 받기  (입력데이터 , 판단데이터(command)
        String command = request.getParameter("cmd");

        //3. 요청 서비스 판단 (command 통해서) 문자열 비교
        //3.1 판단에 의해서 서비스 동작 (DB작업 , 암호화 , ....)
        String viewpage = "";

        switch (command) {
            case "register":
                log.info("/register");
                //회원가입 페이지(VIEW)
                //VIEW 만 전달
                viewpage = "/WEB-INF/views/register/register.jsp";
                //필요에 따라서 request 데이터 저장
                break;
            case "registerok":
                log.info("/registerok");
                //회원가입 처리 (DB작업)
                //입력 데이터 >> DB 연결 >> insert >> 여부 > 처리
                int id = Integer.parseInt(request.getParameter("id"));
                String pwd = request.getParameter("pwd");
                String email = request.getParameter("email");

                RegisterDto dto = new RegisterDto();
                dto.setId(id);
                dto.setPwd(pwd);
                dto.setEmail(email);

                int result = new RegisterDao().writeOk(dto);

                String resultdata = "";
                if (result > 0) {
                    resultdata = "welcome to kosa " + dto.getId() + "님";
                } else {
                    resultdata = "Insert Fail ..... retry...";
                }

                //4. 데이터 저장
                request.setAttribute("data", resultdata);

                //뷰설정하기
                viewpage = "/WEB-INF/views/register/register_welcome.jsp";
                break;
            case "list":
                log.info("/list");
                List<RegisterDto> list = new RegisterDao().selectAll();
                request.setAttribute("list", list);
                viewpage = "/WEB-INF/views/register/registerList.jsp";
                break;
            default:
                viewpage = "/WEB-INF/views/register/register.jsp";
                break;
        }

        //5. View 지정하기
        RequestDispatcher dis = request.getRequestDispatcher(viewpage);

        //6. View forward
        dis.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet()");
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost()");
        doProcess(request, response);
    }
}
