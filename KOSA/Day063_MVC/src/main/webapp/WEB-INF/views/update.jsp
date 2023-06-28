<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>update.jsp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/memo.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous" defer></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/memo.js" defer></script>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6 offset-lg-3">
            <form action="./memo/update" method="post">
                <div class="form-group">
                    <label for="id">ID</label>
                    <input type="button" value="중복 확인" class="btn btn-sm btn-outline-success"
                           onclick="checkId(this.form.id.value)">
                    <input type="text" class="form-control" id="id" name="id" aria-describedby="idHelp"
                           value="${memo.id}">

                    <small id="idHelp" class="form-text text-muted">ID를 입력하세요.</small>
                </div>
                <div class="form-group">
                    <label for="email">EMAIL</label>
                    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp"
                           value="${memo.email}">
                    <small id="emailHelp" class="form-text text-muted">e-mail 주소를 입력하세요.</small>
                </div>
                <div class="form-group">
                    <label for="content">CONTENT</label>
                    <textarea class="form-control" id="content" name="content">${memo.content}</textarea>
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
                <button type="button" class="btn btn-warning" onclick="history.back()">Back</button>
            </form>
        </div>
    </div>
</div>
</body>

</html>
