<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <form action="UserServlet?action=login" method="post" onSubmit="return check(this);">
    	<table align="center" width="300" border="0" class="tb1">
				<tr>
					<td align="right">用户名:</td>
					<td><input type="text" size="30" name="user"></td>
				</tr>	  
				<tr>
					<td align="right">密码:</td>
					<td><input type="text" size="30" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center" height="50">
						<input type="submit" value="登陆">
						<input type="reset" value="重置"> 
					</td>
				</tr>	
    	</table>
    </form>
  </body>
</html>
