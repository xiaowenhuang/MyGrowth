<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta content="text/html; charset=UTF-8">
    
    <title>My JSP 'edit.jsp' starting page</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form>
	    <table>
	    <tr columns=6>
	    	<td>持卡人</td>
	    	<td><input id="cardOwner" type="text" name="cardOwner" value="${card.card_owner }" /></td>
	    	<td>卡号</td>
	    	<td><input id="cardNo" type="text" name="cardNo" value="${card.card_no }" /></td>
	    	<td>备用</td>
	    	<td><input id="null1" type="text" name="null1"/></td>
	    </tr>
	    <tr></tr>
	    </table>
    </form>
  </body>
</html>
