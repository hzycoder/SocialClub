<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'blogEdit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#blogEdit {
	width: 870px;
	height: inherit;
	background-color: #FFFFFF;
}
</style>
</head>

<body>
	<div id="blogEdit">
		<s:form action="subBlogAction" method="post" namespace="/">
			<s:textfield name="title" label="标题" size="50"></s:textfield>
			<br>
			<s:textarea name="content" label="内容" cols="100" rows="20"></s:textarea>
			<s:submit value="提交"></s:submit>
		</s:form>
	</div>
</body>
</html>