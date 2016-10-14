<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.exercise.bean.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'message.jsp' starting page</title>
    
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
    <% String info = (String)request.getAttribute("info") ;
    	if(info!=null){
    		out.println(info);
    	}
    	User user = (User)session.getAttribute("user");
    	if(user!=null){
    %>
    <table align="center" width="350" border="1" height="200" bordercolor="#E8F4CC">
    <tr>
    	<td align="center" colspan="2">
    		<span style="font-weight: bold;font-size: 18px;"><%=user.getUsername() %></span>
    		登陆成功!
    	</td>
    </tr>
    <tr>
    	<td align="right" width="30%">头像:</td>
    	<td>
    		<img src="<%=user.getPhoto() %>" />
    	</td>
    </tr>
    <tr>
    	<td align="right">性别:</td>
    	<td><%=user.getSex() %></td>
    </tr>
    <tr>
    	<td align="right">联系电话：</td>
    	<td><%=user.getTel() %></td>
    </tr>
    <tr>
    	<td alig="right">电子邮箱:</td>
    	<td><%=user.getEmail() %></td>
    </tr>
    </table>
    <% }else{
    		out.println("<br>对不起，您还没有登陆");
    		}
     %>
  </body>
</html>
