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
    <title>ex12_function</title>
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
<h3>JSTL function 라이브러리 함수 사용 예제</h3>
<c:set var="str1" value="String test"/>
<c:set var="str2" value="<a>여기</a>를 클릭해서 다운로드"/>

<p>str1 출력: ${str1}</p>
<p>str1 출력: ${fn:escapeXml(str2)}</p>
<c:if test="${fn:contains(str1, str2)}">
    <p>test 문자열 포함됨</p>
</c:if>
<c:if test="${not fn:contains(str1, str2)}">
    <p>test 문자열 미포함</p>
</c:if>

<p>indexOf(str1, 'S'): ${fn:indexOf(str1, 'S')}</p>
<p>length(str2): ${fn:length(str2)}개</p>

<c:set value="${fn:split(str1, ' ')}" var="spStr"/>
<p>fn:split(str1, ' ) 수행 후 첫 원솟값: ${spStr[0]}</p>
<p>join(str1, '-') "${fn:join(spStr, '-')}"</p>

<p>replace(str1, 'test', '테스트'): ${fn:replace(str1, 'test', '테스트')}</p>
<p>startWith(str1, 'test'): ${fn:startsWith(str1, 'String')}</p>
<p>startWith(str1, 'test'): ${fn:startsWith(str1, 'test')}</p>

<p>substring(str1, 0, 3): ${fn:substring(str1, 0, 3)}</p>
<p>substringAfter(str1, ' '): ${fn:substringAfter(str1, ' ')}</p>
<p>substringBefore(str1, ' '): ${fn:substringBefore(str1, ' ')}</p>

<p>toLowerCase(str1): ${fn:toLowerCase(str1)}</p>
<p>toLowerCase(str1): ${fn:toUpperCase(str1)}</p>
</body>

</html>
