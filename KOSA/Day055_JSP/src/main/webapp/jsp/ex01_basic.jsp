<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ex01_basic.jsp</title>
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
<h2>JSP Basic</h2>
<div>아무거나~</div>
<%
    // 스크립트릿(Scriptlet): 함수를 제외한 자바 코드 - 변수 선언, 제어문 등
    String str = "Hello! JSP를 이용한 웹 브라우저에 출력합니다.";
%>
<h3><%=str%>
</h3>
<hr>
<%
    String str2 = "안녕222! JSP를 이용한 웹 브라우저에 출력합니다.";
    out.println(str2);

    int num = 300;

    /*public String show() {
        return "안녕 JSP입니다.";    // 스크립트릿에서는 함수 선언 불가(선언문에서만 가능)
    }*/
    for (int i = 0; i < 11; i++) {
        out.println(i + "<br>");
    }
%>
<hr>
<%!
    // 선언문(Declaration): 자바 문법, 변수 선언, 함수 등
    public String show() {
        return "안녕 JSP입니다.";    // 선언문에서만 함수 선언 가능
    }
%>
<hr>
<!-- 표현식(Expression) -->
<%=show()%><br>
<%="String output!" %><br>
<%=12345%><br>
<%=12.34%><br>
<h2>num + 200 = <%=num + 200%>
</h2><br>
<%=str2%>
</body>

</html>
