<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>검색 API</title>
    <link rel="icon" href="#">
    <link rel="stylesheet" href="../css/searchView.css">
    <%--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">--%>
    <script type="text/javascript" src="../js/searchView.js" defer></script>
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
<div>
    <div>
        <form id="searchFrm">
            한 페이지에 10개씩 출력됨<br>
            <label for="startNum"></label>
            <select name="startNum" id="startNum">
                <c:forEach var="i" begin="0" end="4">
                    <option value="${10 * i + 1}">${i + 1}페이지</option>
                </c:forEach>
            </select>
            <label for="keyword"></label><input type="text" id="keyword" placeholder="검색어를 입력하세요.">
            <button type="button" id="searchBtn">검색 요청</button>
        </form>
    </div>

    <div class="row" id="searchResult">
        <p>여기에 검색 결과가 출력됩니다.</p>
    </div>
</div>
</body>

</html>
