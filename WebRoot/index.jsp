<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
#index1 {
	width: 650px;
	height: 365px;
	text-align: center;
	margin: 100px auto;
	padding: 0 250px;
	background-image: url('image/background.jpg');
	background-repeat: no-repeat;
	background-position: center;
	color: white;
}
　　
</style>
<base href="<%=basePath%>">

<title>SocialClub</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>
index.jsp
<body>
	
</body>
</html>
