<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>detail.jsp 상세보기 페이지</title>
</head>

<body>
<form action="/board/update/${boardVO.seq}" method="post">
    번호 : <input type="text" name="seq" value="${boardVO.seq}" readonly="readonly"> <br>
    제목 : <input type="text" name="title" value="${boardVO.title}"> <br>
    작성자 : <input type="text" name="writer" value="${boardVO.writer}"> <br>
    내용 : <textarea rows="5" cols="50" name="content">${boardVO.content}</textarea> <br>
    <input type="submit" value="수정하기">
</form>
</body>

</html>