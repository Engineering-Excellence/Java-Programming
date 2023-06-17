<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>

<jsp:useBean id="e" class="kr.or.sw.model.Emp">
    <!-- Setter Method -->
    <jsp:setProperty name="e" property="ename" value="이순신"/>
    <jsp:setProperty name="e" property="empno" value="6000"/>
    <jsp:setProperty name="e" property="pay" value="9999"/>
</jsp:useBean>

<!-- Getter Method -->
이름: <jsp:getProperty name="e" property="ename"/><br>
사번: <jsp:getProperty name="e" property="empno"/><br>
급여: <jsp:getProperty name="e" property="pay"/><br>

<jsp:setProperty name="e" property="*"/>

<h2><%=e%>
</h2>
<hr>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ex14_useBean.jsp</title>
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
<h1>useBean Login</h1>
<%
    Date today = new Date();
    out.println(today + "<br>");
%>
<jsp:useBean id="now" class="java.util.Date"/>
<h3><%=now%>
</h3>
</body>

</html>
