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
			<s:form action="regAction" method="post" namespace="/" theme="simple">
				<br>
				用户名：<s:textfield name="username" value="123" label="用户名" />
				<br>
				<br>
				密&nbsp;&nbsp;码：<s:password name="password" value="123"
					label="密码" />
				<br>
				<br>
				生&nbsp;&nbsp;日:<s:select name="year"
					list="{'','2017','2016','2015','2014','2013','2012','2011','2010','2009','2008','2007',
		'2006','2005','2004','2003','2002','2001','2000','1999','1998','1997','1996','1995','1994','1993',
		'1992','1991','1990','1989','1988','1987','1986','1985','1984','1983','1982','1981','1980','1979',
		'1978','1977','1976','1975'}"/>
				<s:select name="month" list="{'','12','11','10','09','08','07','06','05','04','03','02','01'}"/>
				<s:select name="day" list="{'','01','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18','19','20','21','21','22','23','24','25','26','27','28','29','30','31'}"/>
				<s:property value="#session.RegSUCCESS"></s:property>
				<br>
				<br>
				真&nbsp;&nbsp;名：<s:textfield name="petname" value="狗子"></s:textfield>
				<br>
				<br>
				所在大学：<s:textfield name="college" value="社会大学"></s:textfield>
				<br>
				<br>
				email:<s:textfield name="email" value="123@abc.com"></s:textfield>
				<br>
				<br>
				联系电话:<s:textfield name="phone" value="888555"></s:textfield>
				<br>
				<br>
				<s:submit value="注册" />
				<input type="reset" value="返回" onclick="window.location='login.jsp'">
			</s:form>
		</fieldset>
	</center>

</body>

</html>
