<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>收支管理</title>
  </head>
  
  <body>
  	<form action="" id="mainForm">
  	<table class="tab1">
  	日
  	</table>
  	<table class="tab1">
  	周</table>
  	<table class="tab1">月</table>
  	<table class="tab1">季</table>
  	<table class="tab1">年</table>
  	
  	</form>
  </body>
</html>
