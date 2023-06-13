<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%!
    public int add(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }
%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ex02_basic.jsp</title>
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
Hello, world!<br>
<% int i = 9999; %>
변수 값: <%=i%><br>
함수 호출: <%
    int result = add(10, 2);
    int result2 = mul(30, 20);
%>
<p>결과: <%=result%>
</p>
<p>결과2: <%=result2%>
</p>
<br>
1 ~ 100까지의 합을 출력합니다. →
<%
    int sum = 0;
    for (int j = 0; j < 100; j++) {
        sum += j;
    }
    out.println(sum);
%>
<h3>sum = <%=sum%>
</h3>
<hr>
<h3>구구단 전체 출력하기</h3>
<%
    out.println("<table border='1' cellspacing='20' cellpadding='5'>");
    for (int row = 2; row < 10; row++) {
        out.println("<tr>");
        for (int col = 1; col < 10; col++) {
            out.print(String.format("<td>%d × %d = %2d</td>", row, col, row * col));
        }
        out.println("</tr>");
    }
    out.println("</table>");
%>
</body>

</html>
