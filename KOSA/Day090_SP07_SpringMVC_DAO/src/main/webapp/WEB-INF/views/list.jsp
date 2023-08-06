<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>lists</h1>
<c:forEach var="i" items="${list}">
    <div>
            ${i.get("DEPTNO")}/${i.get("DNAME")}/${i.get("LOC")}
    </div>
</c:forEach>
</body>
</html>
