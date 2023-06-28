<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/2.3.15/angular.min.js"></script>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>

<html>
<head><title>템플릿 페이지를 사용한 웹어플리케이션</title></head>
<body >
<center>
<table  width="100%" border="1" cellpadding="2" cellspacing="0" >
<tr>
    <td colspan="2" >
        <%-- <jsp:include page="../module/top.jsp" flush="false" /> --%>
        <li class="top">
        	<!-- <a href="../module/top.jsp" > -->탑<!-- </a> -->
        	<a href="#">top</a>
        </li>
    </td>
</tr>
<tr>
    <td width="150" valign="top">
    	<li class="left">
    	<!-- <a href="../module/left.jsp" > -->왼쪽<!-- </a> -->
    		<a href="#">left</a>
       	 <%-- <jsp:include page="../module/left.jsp" flush="false" /> --%>
        </li>
    </td>
    <td width="600" valign="top">
    
    <!-- <script type="text/javascript">
     	$(".left").on("click" , function() {
     		//$(".show").load("${CONTENT}");
     		$(".show").load("index.html");
     		//alert("dkdkd");
     	});
     	$(".top").on("click" , function() {
     		//$(".show").load("${CONTENT}");
     		//$(".show").load("index.html");
     		$(".show").append("${CONTENT}");
     		//alert("dkdkd");
     	});
    </script> -->
    <script type="text/javascript">
    $(".left").on("click" , function() {
  		  $(document).ajaxSuccess(function(event, xhr, settings) {
    			if( settings.url == "index.html") {
    				$(".show").load("${CONTENT}");
    		}
  		  });
    }); 
     	
    </script>
    <div class="show" >
    		<%-- <c:out value="${CONTENT}"  /> --%>
    </div>
    
        <%-- <jsp:include page="${CONTENT}" flush="false" /> --%>
    </td>
</tr>
<tr>
    <td width="150" valign="top" align="center">
	    <img src="../module/yun.jpg" border="0">
	</td>
	<td width="600" valign="top">
        <jsp:include page="../module/bottom.jsp" flush="false" />
    </td>
</tr>
</table>
</center>
</body>
</html>