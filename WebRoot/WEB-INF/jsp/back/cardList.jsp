﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>银行卡列表页面</title>
		<link href="<%= basePath%>resources/css/all.css" rel="stylesheet" type="text/css" />
		<script src="<%= basePath%>resources/js/common/jquery-1.7.2.js"></script>
		<script src="<%= basePath%>resources/js/back/cardList.js">		
		</script>
		
	</head>
	<body style="background: #e1e9eb;">
		<form action="<%= basePath%>card/doPost" id="mainForm" method="get">
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">卡片管理</a> &gt; 银行卡列表</div>
				<div class="rightCont">
					<p class="g_title fix">银行卡列表 
					<a class="btn03" href="javascript:addCard('<%=basePath %>');">新 增</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn03" href="#">删 除</a>
					</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">银行卡号：</td>
								<td>
									<input type="text" name="cardNo" class="allInput" value="${cardNo}" />
								</td>
								<td width="90" align="right">持卡人姓名：</td>
								<td>
									<input type="text" name="cardOwner" class="allInput" value="${cardOwner}"/>
								</td>
	              <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       			</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all" onclick="selectAll()"/></th>
								    <th>序号</th>
								    <th>持卡人</th>
								    <th>银行卡号</th>
								    <th>银行名称</th>
								    <th>卡余额</th>
								    <th>操作</th>
								</tr>
								<c:forEach items="${queryList}" var="list" varStatus="status" >
								
								<tr <c:if test="${status.index%2!=0}">style='background-color:#ECF6EE;'</c:if>>
									<td><input type="checkbox" name="id" value=${list.id} /></td>
									<td>${status.index+1}</td>
									<td>${list.card_owner}</td>
									<td>${list.card_no}</td>
									<td>${list.card_name}</td>
									<td>${list.money}</td>
									<td>
										<a href="javascript:toEdit('<%=basePath %>','${list.card_no}','${list.card_owner}');">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="javascript:deleteCard('<%=basePath %>','${list.card_no}','${list.card_owner}')">删除</a>
									</td>
								</tr>
							 </c:forEach>
							</tbody>
						</table>
						<div class='page fix'>
							共 <b>4</b> 条
							<a href="javascript:void(0)" onclick="paginationQuery('First','<%=basePath %>');"  class='first'>首页</a>
							<a href="javascript:void(0)" onclick='paginationQuery("Previous","<%=basePath %>");' class='pre'>上一页</a>
							当前第<span>
							<input type="text" id="currentPage" readonly="readonly" name="currentPage" value="1" style="width:10px"/>
							</span>页
							<a href="javascript:void(0)" onclick='paginationQuery("Next","<%=basePath %>");' class='next'>下一页</a>
							<a href="javascript:void(0)" onclick='paginationQuery("Last","<%=basePath %>");' class='last'>末页</a>
							跳至&nbsp;<input type='text' value='1' style="width:50px" />&nbsp;页&nbsp;
							<a href='###' class='go'>GO</a>
							<%--总页数--%>
							<input type="hidden" id="totalPageCount" value="">
						</div>
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>