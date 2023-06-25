<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>infoView</title>
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
    request.setCharacterEncoding("UTF-8");
    System.out.println(pageContext.findAttribute("infoDTO"));

    Map<String, String[]> map = request.getParameterMap();
    for (Map.Entry<String, String[]> entry : map.entrySet()) {
        System.out.printf("%s : %s%n", entry.getKey(), String.join(", ", entry.getValue()));
    }
%>
<jsp:useBean id="infoDTO" class="edu.kosa.model.InfoDTO"/>
<jsp:setProperty name="infoDTO" property="*"/>
<c:if test="${not empty infoDTO.name}">
    당신의 이름은 ${infoDTO.name}입니다.<br>
</c:if>
<c:if test="${not empty infoDTO.addr}">
    당신이 사는 곳은 ${infoDTO.addr}입니다.<br>
</c:if>
<c:if test="${not empty infoDTO.tel}">
    당신의 연락처는 ${infoDTO.tel}입니다.<br>
</c:if>
</body>

</html>
