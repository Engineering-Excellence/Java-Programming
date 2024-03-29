<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="Stylesheet" href="style/default.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<div id="pageContainer">
		<h3>UI(Css 공통 페이지 적용 확인)</h3>
		<h3>DB연결 정보 확인</h3>
		<%
		Connection conn = null;
		/* http://localhost:8080/WebServlet_92_Board_Model2_Mvc */
		Context context = new InitialContext(); //현재 프로젝트에 이름기반 검색
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); //java:comp/env/ + name

		//POOL안에서 connection 가지고 오기
		conn = ds.getConnection();
		
		boolean connect1 = conn.isClosed();
		
		//POINT
		//POOL에 connection 받환하기
		conn.close(); //반환하기
		boolean connect2 = conn.isClosed();
		%>
		<c:set var="connect1" value="<%= connect1 %>" />
		db 연결여부 : ${ connect1 }<br>
		<c:set var="connect2" value="<%= connect2 %>" />
		db 연결여부 : ${ connect2 }<br>
		
	</div>
</body>
</html>