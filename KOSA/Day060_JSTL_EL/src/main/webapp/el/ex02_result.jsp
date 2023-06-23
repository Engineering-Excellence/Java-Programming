<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ex02_result.jsp</title>
</head>

<body>
<fmt:requestEncoding value="UTF-8"/>
<h2><%=session.getAttribute("message")%>
</h2>
<h2>EL Session: ${sessionScope.message}</h2>
<h3>EL Param<br>${param.search}</h3>
<h3>${param.name}</h3>
<h3>${param['search']}</h3>
<h3>${param['name']}</h3>
<%
    request.setCharacterEncoding("UTF-8");
    String search = request.getParameter("search");
    String name = request.getParameter("name");

    out.print(search + "<br>");
    out.print(name + "<br>");
%>
</body>

</html>
