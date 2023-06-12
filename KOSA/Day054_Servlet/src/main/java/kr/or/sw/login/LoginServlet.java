package kr.or.sw.login;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Pseudo DB
@Data
@NoArgsConstructor
class User {
    private String account;
    private String password;

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }
}

@Slf4j
@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -6883837157687231110L;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Login Call");

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        log.info("ID: {}, PW: {}", id, pw);
        out.write("<!DOCTYPE html><html lang='ko'><head><title>Login Result</title></head><body>");
        User user = new User("admin", "0000");
        if (user.getAccount().equals(id) && !user.getPassword().equals(pw)) {
            out.write("<h1>비밀번호가 틀렸습니다.</h1><br>");
            out.write("<a href='html/loginForm.html'>Login</a>");
        } else if (user.getAccount().equals(id) && user.getPassword().equals(pw)) {
            out.write("<h1>로그인 성공</h1>");
        } else {
            out.write("등록되지 않은 사용자입니다. 회원가입이 필요합니다.<br>");
        }
        out.write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
