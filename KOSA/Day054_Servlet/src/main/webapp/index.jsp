<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>Hello Servlet</title>
</head>

<body>
<h1><a href="${pageContext.request.contextPath}/KOSA">서버 측 시간</a></h1>
<h1><a href="${pageContext.request.contextPath}/login">로그인</a></h1>
<h1><a href="${pageContext.request.contextPath}/html/loginForm.html">Login HTML</a></h1>
<h1><a href="${pageContext.request.contextPath}/html/infoForm.html">Info HTML</a></h1>
<h1><a href="${pageContext.request.contextPath}/jsp/info.jsp">Info JSP</a></h1>
</body>

</html>
