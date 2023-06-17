<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ include file="" %>--%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ex07_mainInfo.jsp</title>
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
<h1>Main Window</h1>
<table border="1" style="width: 700px;">
    <tr>
        <td colspan="2">
            <jsp:include page="/module/Top.jsp"/>
        </td>
    </tr>
    <tr>
        <td style="width: 200px;">
            <jsp:include page="/module/Left.jsp"/>
        </td>
        <td style="width: 500px;">
            Web Site Main Context<br>
            Web Site Main Context<br>
            Web Site Main Context<br>
            Web Site Main Context<br>
            Web Site Main Context<br>
            Web Site Main Context<br>
            Web Site Main Context<br>
            Web Site Main Context<br>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <jsp:include page="/module/Bottom.jsp"/>
        </td>
    </tr>
</table>
</body>

</html>
