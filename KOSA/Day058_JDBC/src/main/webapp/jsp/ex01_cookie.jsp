<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ex01_cookie.jsp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous" defer></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" defer></script>
</head>

<body>
<%
    //  /Users/kyle/Library/Cookies
    Cookie cookie = new Cookie("nickName", "Kyle");

    // Client에게 전달
    response.addCookie(cookie);
%>
서버 도메인 이름: <%=cookie.getDomain()%><br>
서버 설정 이름: <%=cookie.getName()%><br>
서버 설정 값: <%=cookie.getValue()%><br>
<hr>

<%
    // Client 쿠키 정보 읽어오기
    Cookie[] cookies = request.getCookies();
    if (cookies != null || cookies.length > 0) {
        for (int i = 0; i < cookies.length; i++) {
            out.print(cookies[i].getName() + ": ");
            out.print(cookies[i].getValue() + "<br>");
        }
    } else {
        out.print("Client에 저장된 쿠키 정보가 없습니다.");
    }
%>
</body>

</html>
