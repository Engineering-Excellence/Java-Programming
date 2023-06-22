<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Date" %>
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
    <title>ex02_core</title>
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
<!-- Scriptlet과 JSTL 비교 -->
<p>JSTL</p>
<c:forEach var="i" begin="1" end="10" step="2">
    <b>${i}</b>&nbsp;&nbsp;&nbsp;&nbsp;
</c:forEach>
<%
    for (int i = 0; i < 10; i++) {
        if (i % 2 == 1) {
%>
<b><%=i%>
</b>&nbsp;&nbsp;&nbsp;
<%
        }
    }
%>

<hr>

<h2>1 ~ 100까지의 합은?</h2>
<c:set var="sum" value="0"/>
<c:forEach var="i" begin="1" end="100">
    <c:set var="sum" value="${sum + i}"/>
</c:forEach>
<span><font color="blue" size="5">sum: ${sum}</font></span>

<hr>

<h2>구구단 출력</h2>
<table border="1" cellspacing="20" cellpadding="5">
    <c:forEach var="i" begin="2" end="9">
        <tr>
            <c:forEach var="j" begin="1" end="9">
                <td>
                        ${i} * ${j} = ${i * j}
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

<hr>

<%
    String[] sports = {"축구", "농구", "골프", "수영", "볼링", "스카이다이빙"};
    Map<String, Object> map = new HashMap();
    map.put("name", "Kyle");
    map.put("age", 13);
    map.put("tel", "010-1234-5678");
    map.put("date", new Date());
%>
<h1>스포츠 배열 3번째 값부터 3개만 출력</h1>
<c:set value="<%=sports%>" var="sportsArr"/>
<%--<c:set value="${sports}" var="sportsArr"/>--%>
<c:forEach var="sports" items="${sportsArr}">
    ${sports}&nbsp;&nbsp;&nbsp;&nbsp;
</c:forEach>
<br>
<br>
<c:forEach var="sports" items="${sportsArr}" begin="2" end="4" step="1" varStatus="status">
    ${status.index}. ${sports}&nbsp;&nbsp;&nbsp;&nbsp;
</c:forEach>
<br>
<br>
<c:forEach var="sports" items="${sportsArr}" begin="1" step="3" varStatus="status">
    i값: ${sports}<br>
    루프 실행 현재 인덱스 값: ${status.index}<br>
    루프 실행 횟수: ${status.count}<br>
    begin 값: ${status.begin}<br>
    end 값: ${status.end}<br>
    step 값: ${status.step}<br><br>
</c:forEach>

<hr>

<h3>Map Member Info Output</h3>
<p>1. </p>
<c:set value="<%=map%>" var="memberMap"/>
<c:forEach var="member" items="${memberMap}">
    ${member.key}: ${member.value}<br>
</c:forEach>
<br><br>
<p>2. Scriptlet</p>
<%
    String a = "a, b, c, d, e, f, g, h, i, j, k";
    String[] alphabet = a.split(", ");

    for (String s : alphabet) {
%>
<b><%=s%>
</b>
<%
    }
%>

<hr>

<p>3. JSTL</p>
<c:set var="data" value="을지문덕, 김유신, 강감찬, 세종대왕, 이순신, 광개토대왕"/>
<c:forTokens var="varData" items="${data}" delims=", ">
    <b>${varData}</b>
</c:forTokens>
</body>

</html>
