<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>fileUploadPro.jsp</title>
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
<%
    String realPath = "";
    String savePath = "upload";
    String encType = "UTF-8";
    int maxSize = 1024 * 1024 * 5;  // 최대 업로드 파일 크기: 5MB

    // 현재 jsp 페이지의 웹 어플리케이션 상의 절대경로 구하기
    ServletContext context = config.getServletContext();
    realPath = context.getRealPath(savePath + "/"); // upload
    out.print("realPath is: " + realPath + "<br>");

    try {
        MultipartRequest multi = new MultipartRequest(
                request,
                realPath,
                maxSize,
                encType,
                new DefaultFileRenamePolicy()
        );

        Enumeration<String> params = multi.getParameterNames();

        while (params.hasMoreElements()) {
            String name = params.nextElement(); // 전송되는 파라미터 이름
            String value = multi.getParameter(name);    // 전송되는 파라미터 값
            out.print(name + "/" + value + "<br>");
        }   // while end

        out.print("==============================================================================================<br>");

        // 전송할 파일정보 출력
        Enumeration files = multi.getFileNames();
        while (files.hasMoreElements()) {
            String name = files.nextElement().toString();
            String fileName = multi.getFilesystemName(name);    // 물리적 경로에 있는 이름
            String original = multi.getOriginalFileName(name);  // 원본 파일명
            String type = multi.getContentType(name);

            File file = multi.getFile(name);

            out.print("파라미터 이름: " + name + "<br>");
            out.print("실제 파일 이름: " + fileName + "<br>");
            out.print("저장된 파일 이름: " + original + "<br>");
            out.print("파일 타입: " + type + "<br>");

            if (file != null) {
                out.print("크기: " + file.length() + "<br>");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
</body>

</html>
