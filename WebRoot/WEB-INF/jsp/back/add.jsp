<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta content="text/html;charset=utf-8">
  </head> 
  <body>
    <form action="<%=basePath%>add/saveCard" id="mainform" method="get">
	    <table>
	    <tr columns=6>
	    	<td>持卡人</td>
	    	<td><input id="card_owner" type="text" name="card_owner"  /></td>
	    	<td>卡号</td>
	    	<td><input id="card_no" type="text" name="card_no" /></td>
	    	<td>备用</td>
	    	<td><input id="null1" type="text" name="null1"/></td>
	    </tr>
	    <tr>
	    	<td>银行名称</td>
	    	<td><input id="card_name" type="text" name="card_name"  /></td>
	    	<td>卡余额</td>
	    	<td><input id="money" type="text" name="money" /></td>
	    	<td>备用</td>
	    	<td><input id="null1" type="text" name="null1"/></td>
	    </tr>
	    </table>
	        <input type="submit" value="保存11" />
    </form>

  </body>
</html>
