<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'blogContent.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#title{
border-width: 1px;
border-color: black;
border-style: solid;
margin:20px;
padding:5px;
}
#content{
margin:20px;
height:80px;
border-width: 1px;
border-color: black;
border-style: solid;
}
</style>
</head>
<div id="title">标题：<s:property value="titleString"/></div>
<div id="content">正文：<br><s:property value="contentString"/></div>
<input type="button" value="返回" onclick="location='blogList.jsp'">
<body>

</body>
</html>
