<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>결과창</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String email = request.getParameter("email");

    out.print(name + "님 반갑습니다. 비밀번호는 " + password + "이고 이메일 주소는 " + email + "입니다.");
%>

<hr>
<h2><%=name + "님 반갑습니다. 비밀번호는 " + password + "이고 이메일 주소는 " + email + "입니다."%>
</h2>

</body>
</html>