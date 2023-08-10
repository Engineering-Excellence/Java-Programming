<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>searchList.jsp</title>
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
<h3>단일 검색하기</h3>
<form action="/board/search" method="post">
    <select name="condition" id="selectSearch">
        <option value="title">제목</option>
        <option value="writer">작성자</option>
        <option value="content">내용</option>
    </select>
    <input type="text" name="keyword">
    <input type="submit" value="검색">
</form>
<h3>다중 검색하기</h3>
<form action="/board/multiSearch" method="post">
    <input type="checkbox" name="writer" value="writer" checked>
    작성자: <input type="checkbox" name="writer" value="writer">
    제 목: <input type="checkbox" name="title" value="title">
    내 용: <input type="checkbox" name="content" value="content">
    검색어: <input type="text" name="keyword"> <input type="submit" value="검색">
</form>
<hr>
<table border="1" cellspacing="20" cellpadding="5" class="table">
    <thead class="thead-dark">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>내용</th>
        <th>작성날짜</th>
        <th>조회수</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${searchResult}" var="i">
        <tr>
            <td>${i.seq}</td>
            <td><a href="/board/detail/${i.seq}">${i.title}</a></td>
            <td>${i.content}</td>
            <td>${i.writer}</td>
            <td>${i.regDate}</td>
            <td>${i.readCount}</td>
            <td><a href="/board/delete/${i.seq}">×</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="/board/writeForm">글쓰기</a>
</body>

</html>
