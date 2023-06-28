<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head><title>템플릿 페이지를 사용한 웹어플리케이션</title></head>
<body >
<center>
<table  width="700" border="1" cellpadding="2" cellspacing="0" >
<tr>
    <td colspan="2" >
        <jsp:include page="../module/top.jsp" flush="false" />
    </td>
</tr>
<tr>
    <td width="150" valign="top">
        <jsp:include page="../module/left.jsp" flush="false" />
    </td>
    <td width="600" valign="top">
        <jsp:include page="${CONTENT}" flush="false" />
    </td>
</tr>
<tr>
    <td width="150" valign="top" align="center">
	    <img src="../module/yun.jpg" border="0">
	</td>
	<td width="600" valign="top">
        <jsp:include page="../module/bottom.jsp" flush="false" />
    </td>
</tr>
</table>
</center>
</body>
</html>