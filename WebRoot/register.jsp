<%@page import="java.text.SimpleDateFormat"%>
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
<base href="<%=basePath%>">

<title>注册页面</title>
</head>

<body>
	<center>
		<fieldset>
			<legend>请填写以下信息</legend>
			<s:if test="hasFieldError()"></s:if>
			<s:fielderror />
			<s:form action="RegAction" method="post" namespace="/" theme="simple">
				<br>
				用户名：<s:textfield name="u.userName" value="123" label="用户名" />
				<br>
				<br>
				密&nbsp;&nbsp;码：<s:password name="u.password" value="123" label="密码" />
				<br>
				<br>
				<s:property value="#session.RegSUCCESS"></s:property><br>
				<s:submit value="注册" />
				<input type="reset" value="返回" onclick="window.location='login.jsp'">
			</s:form>
		</fieldset>
	</center>

</body>

</html>
