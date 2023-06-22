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
    <title>ex05_jstl.jsp</title>
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
<c:set var="country" value="${'Korea'}"/>

<!-- if -->
<c:if test="${country != null}">
    국가명: <c:out value="${country}"/><br><br>
</c:if>

<!-- switch ~ case -->
<c:choose>
    <c:when test="${country == 'Canada'}">
        <c:out value="${country}"/>의 날씨는 캐나다...<br>
    </c:when>
    <c:when test="${country == 'Korea'}">
        <c:out value="${country}"/>의 날씨는 현재 비가 오고 있습니다.<br>
    </c:when>
    <c:otherwise>그 외 국가의 날씨는 모르겠다.</c:otherwise>
</c:choose>

<hr>

<c:forTokens items="소나타-그랜저-현대차-기아차-쉐보레" delims="-" var="car">
    구분한 글자들 출력: <c:out value="${car}"/><br>
</c:forTokens>
</body>

</html>
