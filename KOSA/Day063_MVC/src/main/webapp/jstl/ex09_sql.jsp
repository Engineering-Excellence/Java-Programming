<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ex09_sql.jsp</title>
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
<sql:query var="rs" dataSource="jdbc/MemoDB">
    SELECT * FROM MEMO
</sql:query>

<%--<table border="1">
    <tr><!-- 필드명 출력 -->
        <c:forEach var="columnName" items="${rs.columnNames}">
            <th><c:out value="${columnName}"/></th>
        </c:forEach>
    </tr>
    <c:forEach items="${rs.rowsByIndex}"><!-- 레코드 수만큼 반복 -->
    <tr>
        <c:forEach var="column" items="${row}" varStatus="i"><!-- 레코드 필드 수만큼 반복 -->
        <td>
            <c:if test="${column != null}">
                <c:out value="${column}"/>
            </c:if>
            <c:if test="${column == null}">
                &nbsp;
            </c:if>
        </td>
        </c:forEach>
    </tr>
    </c:forEach>
</table>--%>

<table border="1">
    <tr> <!-- 필드명 출력 -->
        <c:forEach var="columnName" items="${rs.columnNames}">
            <th><c:out value="${columnName }"/></th>
        </c:forEach>
    </tr>
    <c:forEach var="row" items="${rs.rowsByIndex}"> <!-- 레코드의 수 만큼 반복 -->
        <tr>
            <c:forEach var="column" items="${row}" varStatus="i"> <!-- 레코드의 필드 수 만큼 반복 -->
                <td>
                    <c:if test="${column != null }"> <!-- 해당 필드 값이 null이 아니면 -->
                        <c:out value="${column}"></c:out>
                    </c:if>
                    <c:if test="${column == null}"> <!-- 해당 필드 값이 null 이면 -->
                        &nbsp;
                    </c:if>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>

</html>
