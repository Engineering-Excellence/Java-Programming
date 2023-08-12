<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>list.jsp</title>
    <link rel="icon" href="#">
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
<fmt:requestEncoding value="UTF-8"/>
<h1>List Page</h1>
<hr>
<table border="1" cellspacing="20" cellpadding="5" class="table">
    <thead class="thead-dark">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>내용</th>
        <th>날짜</th>
        <th>조회수</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="i">
        <tr>
            <td>${i.num}</td>
            <td>
                <c:forEach begin="0" end="${i.tab}">
                    &nbsp;&nbsp;&nbsp;
                </c:forEach>
                <a href="/read/${i.num}?page=${page}">${i.subject}</a></td>
            <td>${i.name}</td>
            <td>${i.content}</td>
            <td><fmt:formatDate value="${i.regDate}" pattern="yyyy-MM-dd"/></td>
            <td>${i.hit}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="writeForm">글쓰기</a>
<a href="search">검색</a>
<table>
    <tr>
        <td>
            <!-- 처음 이전 링크 -->
            <c:if test="${page > 1}">
                [<a href="list?page=1">◀︎◀︎</a>]
                [<a href="list?page=${fromPage - 1}">◀︎</a>]
            </c:if>
            <c:if test="${page <= 1}">
                [<span style="color: gray">◀︎◀︎</span>]
                [<span style="color: gray">◀︎</span>]
            </c:if>

            <!-- 블록 범위 출력 -->
            <c:forEach begin="${fromPage}" end="${toPage}" var="i">
                <c:if test="${i == page}">[${i}]</c:if>
                <c:if test="${i != page}">
                    [<a href="list?page=${i}">${i}</a>]
                </c:if>
            </c:forEach>

            <!-- 다음, 이후 링크 -->
            <c:if test="${page < allPage}">
                [<a href="list?page=${page + 1}">▶︎</a>]
                [<a href="list?page=${allPage}">▶︎▶︎</a>]
            </c:if>
            <c:if test="${page >= allPage}">
                [<span style="color: gray">▶︎</span>]
                [<span style="color: gray">▶︎▶︎</span>]
            </c:if>
        </td>
    </tr>
</table>
</body>

</html>
