<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    This is my JSP page. <br>
    
    <%--jsp内置对象，request < session < application.  
     所谓内置对像就是servlet容器或者说jsp容器已经帮助实例化了的对象，
     不需要再次实例化直接使用的对象。  下面就是一个application的例子
     --%>
    <% 
    	String contextConfigLocation = application.getInitParameter("contextConfigLocation"); 
        out.println("contextConfigLocation:"+contextConfigLocation+"<br>");
        %>

  </body>
</html>
