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
	background-repeat: no-repeat;
	background-position: center;
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

<body>
	<div id="index1">
		<s:property value="#session.LOGFAILE"></s:property>
		
		<s:form action="logAction!login" method="post" namespace="/" theme="simple">
			<br>
			<br>
		用户名：<s:textfield name="user.username" size="15" value="admin" />
			<br>
			<br>
		密&nbsp;&nbsp;码：<s:password name="user.password" size="15" />
			<br>
			<br>
		<s:if test="hasFieldError"></s:if>
			<s:fielderror/>
			<s:submit value="登录" theme="simple" />&nbsp;
		<input type=button value="注册" onclick="window.location='register.jsp'" />
		
		</s:form>
	</div>
</body>
</html>
