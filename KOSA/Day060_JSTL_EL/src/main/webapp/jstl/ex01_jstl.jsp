<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ex01_jstl.jsp</title>
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
<%--<c:set var="x">100</c:set>--%><!-- int x = 100; -->
<c:set var="x" value="1000"/><!-- int x = 1000; -->
<h2><c:out value="JSTL로 출력: ${x}"/></h2><!-- out.print(x) -->

<h3>EL 표현으로 출력: ${x}</h3>

<%
    String str = "Hello, JSTL!";
    out.print("Scriptlet으로 출력: " + str + "<br>");
%>
<h2>표현식으로 출력: <%=str%>
</h2>
<%--<h3>표현언어로 출력: ${str}</h3>--%>

<h3>&lt;c:set&gt; 사용 후: <c:out value="${x}"/></h3>
<c:set var="nickname" value="Kyle"/>
<h3>nickname: ${nickname}</h3>

<c:catch var="error">
    <%=10 / 0%>
</c:catch>
<h3>&lt;c:catch&gt;로 잡아낸 오류: <c:out value="${error}"/></h3>

<hr>

<%
    String name = "Kaiser";
    pageContext.setAttribute("id", "admin");
    session.setAttribute("pwd", "1234");
    application.setAttribute("team", "우리 팀");
    request.setAttribute("age", 99);
%>
<%=name%>

<hr>

<c:set value="<%=name%>" var="irum"/>
name1 = ${irum}<br>
name2 = <c:out value="${name}" default="무명인"/><br>
<hr>
EL 표현식 출력<br>
id = ${id}<br>
pwd = ${pwd}<br>
team = ${team}<br>
age = ${age}<br>

<hr>

<%
    int y = 31;
    if (y % 2 == 0) out.print("even");
    else out.print("odd");
%>

<!-- JSTL에서는 else 구문이 없다! -->
<%--
    <c:if test="조건">참일 때 실행문</c:if>
--%>
<c:set value="50" var="a"/>
<c:if test="${a % 2 == 0}"><h1>EVEN</h1></c:if>
<c:if test="${a % 2 != 0}"><h1>ODD</h1></c:if>
${a}

<hr>

<c:if test="${5 < 10}">
    <h3>5는 10보다 작다.</h3>
</c:if>
<c:if test="${5 > 10}">
    <h3>5는 10보다 크다.</h3>
</c:if>

<c:if test="${6 + 3 == 9}"><h1>6 + 3 == 9</h1></c:if>
<c:if test="${6 + 3 != 9}"><h1>6 + 3 != 9</h1></c:if>

<!-- Java: switch ~ case -->
<%--
    <c:choose>
        <c:when test="조건">참일 때의 실행문</c:when>
        <c:when test="조건">참일 때의 실행문</c:when>
        <c:when test="조건">참일 때의 실행문</c:when>
        <c:otherwise>default 실행문</c:otherwise>
    </c:choose>
--%>
<c:choose>
    <c:when test="${5 + 10 == 50}"><h3>5 + 10 == 50</h3></c:when>
    <c:when test="${50 + 10 == 50}"><h3>50 + 10 == 50</h3></c:when>
    <c:when test="${10 + 10 != 20}"><h3>10 + 10 != 20</h3></c:when>
    <c:otherwise>otherwise(default)</c:otherwise>
</c:choose>
</body>

</html>
