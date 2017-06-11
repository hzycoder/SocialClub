<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:head theme="xhtml"/>
<sx:head parseContent="true"/>
<base href="<%=basePath%>">

<title>注册页面</title>

<style type="text/css">
　　form {
	padding: 3em 2em;
	background: #F2F2F2;	
}
form li{
	border: 2px ridge rgba(187, 185, 189, 0.11);
	border-radius: 0.3em;
	-webkit-border-radius:0.3em;
	-moz-border-radius:0.3em;
	-o-border-radius:0.3em;
	list-style:none;
	margin-bottom:12px;
	background:#F0EEF0;

}

input[type="text"], input[type="password"] {
	font-family: 'Droid Sans', sans-serif;
	width:70%;
	padding: 0.5em 0em 0.5em 1em;
	color: #00FF99;
	font-size:20px;
	outline: none;
	background: none;
	border:none;
}
body{
	font-size:100%;
	background: url(images/bg.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
}
img{max-width:100%;}

.d1{
	hight:100%;
	margin:100px;
	padding:100px;
}

input[type="submit"],input[type="reset"]{
	float: center;
	color: #fff;
	cursor: pointer;
	font-weight: 900;
	outline: none;
	font-family: 'Raleway', sans-serif;
	padding: 12px 0px;
	width: 20%;
	font-size: 18px;
	background:#6C496F;
	border:2px solid #6C496F;
	border-radius: 0.5em;
	-webkit-border-radius:0.5em;
	-moz-border-radius:0.5em;
	-o-border-radius:0.5em;
	margin:10px;
}
input[type="submit"]:hover,input[type="reset"]:hover {
	background: #fff;
	color:#6C496F;
	border:2px solid #6C496F;
}

</style>

</head>

<body>
<div class="d1">
	<center>
		<fieldset>
			<legend>请填写以下信息</legend>
			<s:if test="hasFieldError()"></s:if>
			<s:fielderror />
			<s:form action="regAction!add.action" method="post" namespace="/" theme="simple">
				<br>
				<li>*用户名：<s:textfield name="username" value="123" label="用户名" maxlength="20"/></li>
				<br>
				<br>
				<li>*密&nbsp;&nbsp;码：<s:password name="password" value="123" label="密码" /></li>
				<br>
				<br>
				<li><sx:datetimepicker name="birthday" toggleDuration="400" toggleType="explode" label="生日"
				displayFormat="yyyy-MM-dd"/></li>
				<!-- *生&nbsp;&nbsp;日:<s:select name="year"
					list="{'2017','2016','2015','2014','2013','2012','2011','2010','2009','2008','2007',
		'2006','2005','2004','2003','2002','2001','2000','1999','1998','1997','1996','1995','1994','1993',
		'1992','1991','1990','1989','1988','1987','1986','1985','1984','1983','1982','1981','1980','1979',
		'1978','1977','1976','1975'}"
					headerKey="" headerValue="-请选择-" />
				<s:select name="month"
					list="{'01','02','03','04','05','06','07','08','09','10','11','12'}"
					headerKey="" headerValue="-请选择-" />
				<s:select name="day"
					list="{'01','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18','19','20','21','21','22','23','24','25','26','27','28','29','30','31'}"
					headerKey="" headerValue="-请选择-"/> -->
				<br>
				<br>
				<li>真&nbsp;&nbsp;名：<s:textfield name="petname" value="狗子"></s:textfield></li>
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
		</fieldset>
		</center>
</div>
</html>
