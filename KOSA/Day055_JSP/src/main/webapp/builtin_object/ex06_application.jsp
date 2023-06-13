<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>ex06_application.jsp</title>
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
<h2>application 웹 경로</h2>
<hr>
<!--
    가상 경로(웹 브라우저에서 바라보는 경로)
    http://localhost:8080/download/memo.txt

    물리적 경로
    /Users/kyle/Documents/Study/Java/KOSA/Day055_JSP/src/main/webapp/download/memo.txt

    톰캣 구동시 물리적 경로
    /Users/kyle/Documents/Study/Java/KOSA/Day055_JSP/target/Day055_JSP-1.0-SNAPSHOT/download/memo.txt
-->
<%
    String resourcePath = "/download/memo.txt";
    out.println(resourcePath + "<br>");

    // 가상경로에서 물리적 경로 얻어내기
    out.println("\"" + request.getContextPath() + "\"<br>");

    String contextPath = application.getRealPath(request.getContextPath());
    String realPath = application.getRealPath(resourcePath);
    out.println("contextPath: " + contextPath + "<br>");
    out.println("realPath: " + realPath + "<br>");
%>
<hr>
</body>

</html>
