<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%session.setAttribute("message", "Daebo 2nd");%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ex02_el.jsp</title>
</head>

<body>
<fmt:requestEncoding value="UTF-8"/>
<form action="ex02_result.jsp" method="post">
    <table border="1">
        <tr>
            <td>검색</td>
            <td>
                <label>
                    <input type="search" placeholder="검색어를 입력하세요." name="search">
                </label>
            </td>
        </tr>
        <tr>
            <td>이름</td>
            <td>
                <label>
                    <input type="text" placeholder="이름을 입력하세요." name="name">
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="전송"></td>
        </tr>
    </table>
</form>

<form action="ex02_el.jsp" method="post">
    <ul>
        <li>
            <label>
                <input type="text" id="irum" name="irum" value="${param['irum']}" placeholder="아무 이름이나 입력하세요.">
            </label>
        </li>
        당신의 이름은 ${param.irum}입니다.
    </ul>
</form>
</body>

</html>
