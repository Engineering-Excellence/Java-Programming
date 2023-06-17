<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sample page</title>
</head>

<body>
<%
    /*
        if (code.equals("A")) {
            viewURI = "/module/a.jsp";
        } else if (code.equals("B")) {
            viewURI = "/module/b.jsp";
        } else if (code.equals("C")) {
            viewURI = "/module/c.jsp";
        }
    */

    String code = request.getParameter("code");
    String viewURI = switch (code) {
        case "A" -> "/module/a.jsp";
        case "B" -> "/module/b.jsp";
        case "C" -> "/module/c.jsp";
        default -> null;
    };
%>

<jsp:forward page="<%= viewURI %>"/>
</body>

</html>