<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../include/header.jsp" %>

<!-- 3초후 메인페이지로 이동 -->
<meta http-equiv="refresh" content="3,${path}">
<title>denied.jsp page</title>

</head>
<body>
<p><font color="red">  ${errMsg} </font> </p>
</body>
</html>






















