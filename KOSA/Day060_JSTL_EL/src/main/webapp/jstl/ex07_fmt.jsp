<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="ko_KR"/>
<%--<fmt:setBundle basename="classes.testBundle"/><!-- 경로.파일명 -->--%>

<jsp:useBean id="date" class="java.util.Date"/>
<%
    Date date2 = new Date();
    out.print(date2 + "<br>");
%>

<hr>

<fmt:bundle basename="classes.testBundle">
    <fmt:message key="name"/><br>
    <fmt:message key="message"/><br>
    <fmt:message key="say"/><br>
    <fmt:message key="say2">
        <fmt:param>kosa</fmt:param>
    </fmt:message>
</fmt:bundle>

<hr>

<fmt:formatNumber value="50000" type="currency"/><br>
<fmt:formatNumber value="0.15" type="percent"/><br>
<fmt:formatNumber value="1234567890" pattern="###,###,###"/><br>

<hr>

<fmt:formatDate value="${date}" type="date"/><br>
<fmt:formatDate value="${date}" type="time"/><br>
<fmt:formatDate value="${date}" type="both"/><br>

<hr>

<fmt:formatDate value="${date}" type="both" timeStyle="short" dateStyle="short"/><br>
<fmt:formatDate value="${date}" type="both" timeStyle="long" dateStyle="long"/><br>

<hr>

<p>number: <fmt:formatNumber value="12345.6789" type="number"/></p>
<p>number: <fmt:formatNumber value="12345.6789" type="currency"/></p>