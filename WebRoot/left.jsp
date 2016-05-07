<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="">
    	<table width="217" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="images/left_bg.jpg"	>
    	<tr><td height="37" colspan="2" background="images/title.jpg">&nbsp;</td></tr>
    	<c:forEach>
    	<tr>
    		<td width="82" height="30" align="right" background="images/left_bg.jpg">
    		<img alt="" src="images/ico.jpg" width="9" height="9"></td>
    		<td width="135" height="30" style="padding-left:5px;">&nbsp;
    		<a href="LinkmanServlet?action=queryLinkman&id=${groupForm.id }">${groupForm.name }</a>
    		</td>
    	</tr>
    	</c:forEach>
    	<tr>
    		<td colspan="2" align="right" valign="top" style="padding-right:20px;" background="images/left_bg.jpg">
    		<img alt="" src="images/left_line.jpg" width="152" height="3"></td>
    	</tr>
    	</table>
    </form>
  </body>
</html>
