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

<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>

<body>
	<div id="index1">
		<div class="inset">
			<div class="login-head">
				<h1>Login Form</h1>
			</div>
			<s:property value="#session.LOGFAILE"></s:property>
			<s:form action="logAction" method="post" namespace="/" theme="simple">
				<li><s:textfield name="user.username" size="15" value="admin"
						onfocus="this.value = '';" /> <a class=" icon user"></a></li>
				<div class="clear"></div>
				<li><s:password name="user.password" size="15"
						onfocus="this.value = '';" /> <a class="icon lock"></a></li>
				<div class="clear"></div>
				<s:submit value="Sign in" theme="simple" />
				<input type="reset" value="register" onclick="window.location='register.jsp'">
				<div class="clear"></div>
				<s:if test="hasFieldError"></s:if>
				<s:fielderror />
			</s:form>


		</div>
	</div>
	<div class="clear"></div>
</body>
</html>
