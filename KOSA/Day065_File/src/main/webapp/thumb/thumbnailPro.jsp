<%@ page import="java.util.Enumeration" %>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="edu.kosa.thumb.Thumbnail" %>
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
    <title>thumbnailPro.jsp</title>
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
<%--<%
    String realPath = "";
    String savePath = "upload";
    String encType = "UTF-8";
    int maxSize = 1024 * 1024 * 5;  // 최대 업로드 파일 크기: 5MB

    // 현재 jsp 페이지의 웹 어플리케이션 상의 절대경로 구하기
    ServletContext context = config.getServletContext();
    realPath = context.getRealPath(savePath + "/"); // upload
    out.print("realPath is: " + realPath + "<br>");

    MultipartRequest multi = new MultipartRequest(
            request,
            realPath,
            maxSize,
            encType,
            new DefaultFileRenamePolicy()
    );

    Enumeration files = multi.getFileNames();
    int zoom = 5;

    ////////////////////////////////////////
    for (int i = 0; i < files.size(); i++) {
        String originalFileName = files.get(i).getOriginalFilename();
        int index = originalFileName.lastIndexOf(".");
        String fileName = originalFileName.substring(0, index); // 파일명
        String fileExt = originalFileName.substring(index + 1); // 확장자

        File file = new File(originalFileName);

        savePath.get(i).transferTo(file);

        // 썸네일을 생성하는 메서드를 호출한다.
        Thumbnail.createImage(file.getAbsolutePath(), originalFileName, fileExt, zoom);
    }   // for end
    ////////////////////////////////////////

    out.print("==============================================================================================<br>");

    // 전송할 파일정보 출력
    while (files.hasMoreElements()) {
        String name = files.nextElement().toString();
        String fileName = multi.getFilesystemName(name);    // 물리적 경로에 있는 이름
        String original = realPath + fileName;
        String thumbFileName = realPath + fileName;
    }
%>--%>

원본 파일 저장 경로 및 파일명: <%=original%><br>
<img src="<%=original%>" alt="원본" border="0"><br>
<%=Thumbnail.createImage(original, thumbFileName, savePath, zoom)%>

썸네일 이미지 저장 경로 및 파일명<br>
원본 파일 저장 경로 및 파일명: <%=thumbFileName%><br>
<img src="../upload/<%=thumbFileName%>" alt="원본" border="0">
</body>

</html>
