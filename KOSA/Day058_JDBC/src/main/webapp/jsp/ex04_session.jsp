<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Session 변수</title>
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
<!--
    application.setAttribute("count", 0);
    count: 전역변수, 서버에 접속한 브라우저가 공유하는 자원

    session.setAttribute("ID", "prophet");
    ID는 sessionID에 고유하게 부여하는 변수
    웹 서버에 접속한 사용자의 고유한 정보: loginID, shopping cart 활용 데이터 등
 -->

<h3>Session 정보</h3>
서버가 부여한 ID: <%=session.getId()%>
<%
    session.setAttribute("ID", "prophet");
    session.setAttribute("Login", "Fail");
%>
<hr>

<h3>Session 값 읽어오기</h3>
<%
    String id = session.getAttribute("ID").toString();
    String login = (String) session.getAttribute("Login");
%>
ID: <%=id%><br>
Login: <%=login%>
<hr>

<%
    // Session ID 삭제
    session.invalidate();   // 로그아웃
%>
</body>

</html>
