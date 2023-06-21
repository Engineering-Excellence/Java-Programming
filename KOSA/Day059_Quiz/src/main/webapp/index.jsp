<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>quiz_useBean.jsp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous" defer></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" defer></script>
    <script src="js/gift.js" defer></script>
</head>

<body>
<%--<jsp:useBean id="gift" class="kr.or.sw.model.GiftVO">
  <jsp:setProperty name="gift" property="GNo" value="10"/>
  <jsp:setProperty name="gift" property="GName" value="키링"/>
  <jsp:setProperty name="gift" property="GStart" value="1000"/>
  <jsp:setProperty name="gift" property="GEnd" value="5000"/>
</jsp:useBean>--%>
<h2>상품정보</h2>
<form id="giftForm" method="post">
    <table border="1" cellpadding="5" cellspacing="20">
        <tr>
            <th>상품번호</th>
            <td colspan="2">
                <input type="text" name="gNo" id="gNo">
            </td>
        </tr>
        <tr>
            <th>상품명</th>
            <td colspan="2">
                <input type="text" name="gName" id="gName">
            </td>
        </tr>
        <tr>
            <th>최저가</th>
            <td colspan="2">
                <input type="text" name="gStart" id="gStart">
        </tr>
        <tr>
            <th>최고가</th>
            <td colspan="2">
                <input type="text" name="gEnd" id="gEnd">
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="button" class="button" name="register" id="register" onclick="submitForm('/gift/register')"
                       value="등록">
            </td>
            <td>
                <input type="button" class="button" name="search" id="search" onclick="submitForm('/gift/search')"
                       value="확인">
            </td>
        </tr>
    </table>
</form>
</body>

</html>
