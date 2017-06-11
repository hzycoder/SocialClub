<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:head theme="xhtml" />
<sx:head parseContent="true" />
<base href="<%=basePath%>">

<title>注册页面</title>

<style type="text/css">
　　form {
	background: #F2F2F2;
	padding: 3em 2em;
}

form li {
	text-align: left; width : 500px;
	border: 2px ridge rgba(187, 185, 189, 0.11);
	border-radius: 0.3em;
	-webkit-border-radius: 0.3em;
	-moz-border-radius: 0.3em;
	-o-border-radius: 0.3em;
	list-style: none;
	margin-bottom: 12px;
	background: #F0EEF0;
	width: 500px;
}

input[type="text"], input[type="password"] {
	font-family: 'Droid Sans', sans-serif;
	width: 70%;
	padding: 0.5em 0em 0.5em 1em;
	color: black;
	font-size: 20px;
	outline: none;
	background: none;
	border: none;
}

body {
	font-size: 100%;
	background: url(images/bg.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
}

img {
	max-width: 100%;
}

.d1 {
	padding-top: 100px;
	margin: 0 auto;
}

input[type="submit"], input[type="reset"] {
	float: center;
	color: #fff;
	cursor: pointer;
	font-weight: 900;
	outline: none;
	font-family: 'Raleway', sans-serif;
	padding: 12px 0px;
	width: 20%;
	font-size: 18px;
	background: #6C496F;
	border: 2px solid #6C496F;
	border-radius: 0.5em;
	-webkit-border-radius: 0.5em;
	-moz-border-radius: 0.5em;
	-o-border-radius: 0.5em;
	margin: 10px;
}

input[type="submit"]:hover, input[type="reset"]:hover {
	background: #fff;
	color: #6C496F;
	border: 2px solid #6C496F;
}
</style>

</head>

<body>
	<div class="d1">
		<center>
			<legend>请填写以下信息</legend>
			<s:if test="hasFieldError()"></s:if>
			<s:fielderror />
			<s:form action="regAction!add.action" method="post" namespace="/"
				theme="simple">
				<br>
				<li>*用户名：<s:textfield name="username" value="123" label="用户名"
						maxlength="20" /></li>
				<br>
				<br>
				<li>*密&nbsp;&nbsp;码：<s:password name="password" value="123"
						label="密码" /></li>
				<br>
				<br>
				<li><sx:datetimepicker name="birthday" toggleDuration="400"
						toggleType="explode" label="生日" displayFormat="yyyy-MM-dd" /></li>
				<br>
				<br>
				<li>昵&nbsp;&nbsp;称：<s:textfield name="petname" value="狗子"></s:textfield></li>
				<br>
				<br>
				<li>所在大学：<s:textfield name="college" value="社会大学"></s:textfield></li>
				<br>
				<br>
				<li>email:<s:textfield name="email" value="123@abc.com"></s:textfield></li>
				<br>
				<br>
				<li>联系电话:<s:textfield name="phone"></s:textfield></li>
				<br>
				<br>
				<s:submit value="注册" />
				<input type="reset" value="返回" onclick="window.location='login.jsp'">
			</s:form>
		</center>
	</div>
</html>
