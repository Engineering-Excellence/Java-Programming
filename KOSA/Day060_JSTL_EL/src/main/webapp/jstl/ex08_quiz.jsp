<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ex08_quiz.jsp</title>
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
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="ko_KR"/>
<fmt:setBundle basename="quiz.quiz"/>

<div>
    1. name=이름, address=주소 출력<br>
    이름: <fmt:message key="name"/><br>
    주소: <fmt:message key="address"/><br>
</div>

<hr>

<div>
    2. 1~100 숫자 중 3의 배수의 개수와 합을 출력하는 프로그램<br>
    <c:set var="sum" value="0"/>
    <c:set var="cnt" value="0"/>
    <c:forEach var="i" begin="3" end="100" step="3">
        <c:set var="sum" value="${sum + i}"/>
        <c:set var="cnt" value="${cnt + 1}"/>
    </c:forEach>
    sum = <c:out value="${sum}"/><br>
    cnt = <c:out value="${cnt}"/><br>
</div>

<hr>
</body>

</html>
