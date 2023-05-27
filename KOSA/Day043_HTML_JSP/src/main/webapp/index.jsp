<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.Date" %> <%-- 이게 임포트임 --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Server Test - Tomcat 실행</title>
</head>
<body>
<%--
<% %>
<%! %>
<%= %>
 --%>

<%= new Date() %>
<hr color="red" size="2">

<%
    request.setCharacterEncoding("UTF-8");

    for (int i = 1; i <= 10; i++) {
        out.print(i + " ");
    }
%> <br>

<% for (int i = 1; i <= 10; i++) { %>
hello <%=i %> <br/>
<% } //for end%>


</body>
</html>