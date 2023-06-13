<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>ex05_application.jsp</title>
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
<h2>web.xml 설정 파일에 등록되어있는 내용을 application을 통해 읽어오기</h2>
<!--
    <context-param> 내부에 설정하고 application read
    web 전체에서 공통으로 사용되는 정보들
    웹 경로, 저장경로
    IP, 계정, 패스워드 등
-->
<%
    Enumeration<String> e = application.getInitParameterNames();
    while (e.hasMoreElements()) {
        String element = e.nextElement();
//        out.println(element + "<br>");
%>
<h3><%=element%>
</h3>
<%
    }   // while end

    String emailValue = application.getInitParameter("email");
    out.println("initParameter_emailValue: " + emailValue + "<br>");

    String infoValue = application.getInitParameter("info");
    out.println("initParameter_infoValue: " + infoValue + "<br>");
%>
</body>

</html>
