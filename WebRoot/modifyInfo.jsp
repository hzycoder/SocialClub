<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'modifyInfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.input.in {
	width: 295px;
	height: 36px;
	border: 1px solid #cad2db;
	padding: 0 5px;
	-moz-border-radius: 5px;
	line-height: 36px;
	font-size: 14px;
	color: #171171;
	font-family: Arial;
	margin-bottom: 20px;
	border-radius: 5px;
}

.input.in:focus {
	-moz-transiton: border linear .2s, -moz-box-shadow linear .2s;
	outline: none;
	border-color: rgba(173, 173, 173, 75);
	box-shadow: 0px 0px 8px rgba(173, 173, 173, 0.5);
	-moz-box-shadow: 0 0 8px rgba(173, 173, 173, .5);
	-webkit-box-shadow: 0 0 8px rgba(173, 173, 173, 3);
	border: 1px solid #6192c8;
}

h2 {
	color: #4f5d80;
	text-transform: uppercase;
	font-size: 18px;
	font-weight: normal;
	margin-bottom: 11px;
	font-family: "microsoft yahei", Arial, Helvetica, sans-serif
}

.submit {
	float: right;
	width: 122px;
	height: 32px;
	border: none;
	background: -moz-linear-gradient(top, #f2f3f7, #e4e8ec);
	color: #000000;
	padding-bottom: 2px;
	font-size: 14px;
	font-weight: bold;
}

.submit:hover {
	background: -webkit-linear-gradient(top, #fefefe, #ebeced);
	background: -moz-linear-gradient(top, #f2f3f7, #ebeced);
	background: linear-gradient(top, #f2f3f7, #ebeced)
}

.submit:active {
	top: 1px;
	box-shadow: 0 1px 3px #a8abae inset, 0 3px 0 #fff;
	background: -webkit-linear-gradient(top, #e4e8ec, #e4e8ec);
	background: -moz-linear-gradient(top, #e4e8ec, #e4e8ec);
	background: linear-gradient(top, #e4e8ec, #e4e8ec)
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function getUrl(file) {
	}
</script>
</head>

<body>
	<div style="width:403px; margin: 0 auto;">
		<div style="padding: 28px 47px 20px 47px;">
			<s:form action="infoAction!modify.action" method="post"
				theme="simple">
				<h2>
					昵&nbsp;&nbsp;称：
					<s:property value="#user.petname" />
				</h2>
				<s:textfield name="user.petname" cssClass="input in"
					value="%{#session.user.petname}">
				</s:textfield>
				</br>
				<h2>生&nbsp;&nbsp;日：</h2>
				<s:textfield name="user.birthday" cssClass="input in">
					<s:param name="value">
						<s:date name="%{#session.user.birthday}" format="yyyy-MM-dd" />
					</s:param>
				</s:textfield>
				<br>
				<h2>所在单位：</h2>
				<s:textfield name="user.college" value="%{#session.user.college}"
					cssClass="input in"></s:textfield>
				</br>
				<h2>电&nbsp;&nbsp;话：</h2>
				<s:textfield name="user.phone" value="%{#session.user.phone}"
					cssClass="input in"></s:textfield>
				</br>
				<s:submit cssClass="submit"></s:submit>
			</s:form>
		</div>
	</div>
</body>
</html>
