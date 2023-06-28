<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>registerList.jsp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous" defer></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js" defer></script>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6 offset-lg-3">
            <table>
                <tr>
                    <th>ID</th>
                    <th>PWD</th>
                    <th>Email</th>
                    <th></th>
                </tr>
                <c:set var="i" value="0"/>
                <c:forEach var="list" items="${list}">
                    <tr>
                        <td id="id${i = i + 1}">${list.id}</td>
                        <td>${list.pwd}</td>
                        <td>${list.email}</td>
                        <td>
                            <input type="button" class="btn btn-sm btn-outline-primary" value="수정"
                                   onclick="updateMemo(document.getElementById(`id${i}`).innerText)">
                            <input type="button" class="btn btn-sm btn-outline-danger" value="삭제"
                                   onclick="deleteMemo(document.getElementById(`id${i}`).innerText)">
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="button" value="뒤로가기" style="display: block; margin: 0 auto;"
                   onclick="history.back()">
        </div>
    </div>
</div>
</body>

</html>
