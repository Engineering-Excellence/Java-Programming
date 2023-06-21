<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ page import="edu.kosa.members.*" %>
<%@ include file="../view/color.jsp" %>


<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="vo" class="edu.kosa.members.MemberVO">
    <jsp:setProperty name="vo" property="*"/>
</jsp:useBean>

<%
    String id = (String) session.getAttribute("memID");
    vo.setId(id);

    MemberDAO dao = MemberDAO.getInstance();
    dao.update(vo);
%>

<link href="../view/mystyle.css" rel="stylesheet" type="text/css">
<<table>
<tr bgcolor="<%= title_c %>">
    <td>
        <font size="5" color="red"><b>회원 정보가 수정 되었습니다.</b></font>
    </td>
</tr>
<tr>
    <td bgcolor="<%= title_c %>" align="center">
        <p>입력하신 내용이 수정 완료 되었습니다. </p>
    </td>
</tr>

<tr>
    <td bgcolor="<%= title_c %>" align="center">
        <form>
            <input type="button" value="메인으로" onclick="window.location='main.jsp' ">
        </form>
        5초 후에 메인으로 이동합니다....
        <meta http-equiv="Refresh" content="5; url=main.jsp">
    </td>
</tr>
</table>













