<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ex01_el.jsp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous" defer></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" defer></script>
    <style type="text/css">
        table, td {
            border: 1px solid;
            width: 700px;
        }
    </style>
</head>

<body>
<!-- \문자: 해당 문자를 표현(이스케이프) -->
<h3>\${5 + 7} = ${5 + 7}</h3>
<h3>\${5 - 7} = ${5 - 7}</h3>
<h3>\${5 * 7} = ${5 * 7}</h3>
<h3>\${5 / 7} = ${5 / 7}</h3>
<h3>\${5 div 7} = ${5 div 7}</h3>
<h3>\${5 % 7} = ${5 % 7}</h3>
<h3>\${5 mod 7} = ${5 mod 7}</h3>

<hr>

<h3>\${5 != 7} = ${5 != 7}</h3>
<h3>\${5 > 7} = ${5 > 7}</h3>
<h3>\${5 >= 7} = ${5 >= 7}</h3>
<h3>\${5 <= 7} = ${5 <= 7}</h3>

<hr>

<h3>\${5 + 3 == 8 ? 8 : 10} = ${5 + 3 == 8 ? 8 : 10}</h3>
<h3>\${"문자열 출력"} = ${"문자열 출력"}</h3>
<h3>\${12.37} = ${12.37}</h3>
<h3>\${325} = ${325}</h3>

<hr>

<table>
    <tr>
        <td>\${header['host']}</td>
        <td>${header['host']}</td>
    </tr>
    <tr>
        <td>\${header['user-agent']}</td>
        <td>${header['user-agent']}</td>
    </tr>
    <tr>
        <td>\${headerValues}</td>
        <td>${headerValues}</td>
    </tr>
</table>
</body>

</html>
