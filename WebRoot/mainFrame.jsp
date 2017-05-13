<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mainFrame.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#textarea {
	width: 820px;
	margin: 0 auto;
	height: 200px;
	padding: 20px;
	padding-bottom: 0;
}

#act_list {
	width: 820px;
	margin: 0 auto;
	height: inherit;
	padding: 20px;
	padding-top: 0;
}

#act_list table {
	margin: 10px;
	width: 800px;
}
</style>
  </head> 
  <body>
  </body>
</html>
