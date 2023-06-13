<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>request 객체 다루기</title>
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
<!--
    웹 브라우저가 웹 서버에 전송한 요청 관련 정보 제공
    주요 기능
    - 클라이언트(웹 브라우저)와 관련된 정보 읽기 기능
    - 서버와 관련된 정보 읽기 기능
    - 클라이언트가 전송한 요청 파라미터 읽기 기능
    - 클라이언트가 전송한 요청 헤더 읽기 기능
    - 클라이언트가 전송한 쿠키 읽기 기능
    - 속성 처리 기능
-->
<h1>request 객체 다루기</h1>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    out.print("ID: " + id);
    // Query String: URL?변수=값
%>
<hr>
<h3>request 객체가 가지고 있는 메서드</h3>
<ul>
    <li>클라이언트 IP 정보 가져오기: <%=request.getRemoteAddr()%>
    </li>
    <li>요청 방식(인코딩): <%=request.getCharacterEncoding()%>
    </li>
    <li>전송 방식: <%=request.getMethod()%>
    </li>
    <li>서버 이름: <%=request.getServerName()%>
    </li>
    <li>서버 포트: <%=request.getServerPort()%>
    </li>
    <li>컨텍스트 정보: <%=request.getContextPath()%>
    </li>
    <li>전송된 데이터: <%=request.getParameter("id")%>
    </li>
</ul>
</body>

</html>
