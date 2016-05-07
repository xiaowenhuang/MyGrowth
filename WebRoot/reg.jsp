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
		<form action="RegServlet" method="post" onsubmit="return reg(this)">
			<table align="center" width="450" border="0">
			<tr>
				<td align="right">用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="password" name="password"></td>
			</tr>			
			<tr>
				<td align="right">确认密码：</td>
				<td><input type="password" name="repassword"></td>
			</tr>			
			<tr>
				<td align="right">性别：</td>
				<td>
					<input type="radio" name="sex" value="男" checked="checked">男
					<input type="radio" name="sex" value="女" >女
				</td>
			</tr>			
			<tr>
				<td align="right">头像：</td>
				<td>
					<select name="photo" id="photo" onchange="change();">
						<option value="images/1.gif" selected="selected">头像一</option>
						<option value="images/2.gif">头像二</option>
					</select>
					<img id="photoImg src="images/1.gif">	
				</td>
			</tr>			
			<tr>
				<td align="right">联系电话：</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td align="right">电子邮箱：</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="注册">
					<input type="reset" value="重置"> 
				</td>
			</tr>
			</table>
		</form>
  </body>
</html>
