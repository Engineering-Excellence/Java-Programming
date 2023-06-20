<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String user = "java", passwd = "1004";   // db에 들어 있는

    String id = request.getParameter("uid");
    String pwd = request.getParameter("pwd");
    boolean loginState = false;

    // db 연결 확인...
    // id && pwd 일치시 회원이라고 가정하면,....

    if (user.equals(id) && passwd.equals(pwd)) {
        session.setAttribute("memberId", id);
        loginState = true;
    }
%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>Session check</title>
</head>

<body>
<% String UserID = (String) session.getAttribute("memberId"); %>
<%= UserID %> <br><br>

<%
    if (loginState) {
        out.print(id + "님 로그인한 상태");
    } else {
        out.print("회원이 아니십니다. 회원가입 하세요.");
    }

    //session 제거
    //session.invalidate();
%>
</body>

</html>