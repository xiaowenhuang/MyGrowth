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
    
    <title>My JSP 'linkmanModify.jsp' starting page</title>
    
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
  <c:set var="linkman" value="${requestScope.linkman }"/>
  <form action="LinkmanServlet?action=saveModify" name="form1" method="post"
  onsubmit="return check(this)">
  	姓名:<input name="name" type="text" id="name" value="${linkman.name }">
  	<input name="id" type="hidden" id="id" value="${linkman.id }">
  	电话:<input name="tel" type="text" id="tel" value="${linkman.tel }">
  	手机:<input name="mobileTel" type="text" id="mobileTel" value="${linkman.mobileTel }">
  	E－mail地址:<input name="email" type="text" id="email" value="${linkman.email }">
  	地址:<input name="address" type="text" id="address" value="${linkman.address }">
  	邮编:<input name="postcode" type="text" id="postcode" value="${linkman.postcode }">
  	所在组:
  	<select name="byGroup">
  		<c:forEach var="groupForm" items="${requestScope.groupList }">
  			<option value="${groupForm.id }"
  			<c:if test="${groupForm.id==linkman.byGroup }">selected</c:if>>${groupForm.name }</option>	
  			</c:forEach>
  	</select>
  	<input name="Submit" type="submit" class="btn_bg" value="保存">
  	<input name="Reset" type="reset" class="btn_bg" value="重置">
  	<input name="Button" type="button" class="btn_bg" value="返回" onclick="history.back(-1);">
  </form>
  </body>
</html>
