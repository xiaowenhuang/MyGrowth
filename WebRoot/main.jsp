<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%-- <jsp:include page="GroupServlet;">
	<jsp:param value="query" name="action"/>
</jsp:include> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
  	${sessionScope.user }的通迅录 &gt; 通迅录主页&gt;&gt;<br>
  	共有<font color="#FF0000">${requestScope.linkmanCount }</font>个联系人
  	<br>
  	<input name="Button" type="button" class="btn_bg1" value="添加联系人" onclick="window.location.href='GroupServlet?action=query_add'">
  	<input name="Button2" type="button" class="btn_bg1" value="安全退出" onclick="window.location.href='UserServlet?action=exit'">
  	
  	
  </body>
</html>
