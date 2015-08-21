<%@ page language="java" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>上传文件</title>

<%-- <link rel="stylesheet" href="<%=path%>/resources/css/main.css" type="text/css" /> --%>
</head>
<body>
<div align="center">

<h1>上传附件</h1>
<form method="post" action="<%=path %>/uploadFile/doUpload" enctype="multipart/form-data">

<input type="file" name="file"/>
<input type="submit"/>
</form>
</div>
</body>
</html>