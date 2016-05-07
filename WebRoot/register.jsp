<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
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
		<form action="UserServlet?action=register" method="post" onsubmit="return check(this)">
			<table align="center" width="450" border="0">
			<tr>
				<td align="right">用户名：</td>
				<td><input type="text" size="30" name="user"></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="password" size="30" name="pwd"></td>
			</tr>			
			<tr>
				<td align="right">确认密码：</td>
				<td><input type="password" size="30" name="repwd"></td>
			</tr>			
		
			<tr>
				<td align="right">电子邮箱：</td>
				<td><input type="text" size="30" name="email"></td>
			</tr>
			<tr>
				<td align="right">居住地：</td>
				<td><input type="text" size="30" name="abode"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" class="btn_bg" value="注册">
					<input type="reset" class="btn_bg"  value="重置"> 
					<input type="button" class="btn_bg" value="返回" onclick="window.location.href='index.jsp'">
				</td>
			</tr>
			</table>
		</form>
  </body>
</html>
