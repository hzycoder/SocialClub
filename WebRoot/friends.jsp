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

<title>My JSP 'MyFriends.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.friedns {
	width: 800px;
	height: 45px;
	background-color: #CCDDCC;
	text-align: center;
	padding: 22.5px;
}

.headpic {
	float: left;
	height: 45px;
	width: 45px;
	background-color: orange;
}

.act {
	float: left;
	width: 500px;
	height: 45px;
	background-color: orange;
	margin-left: 20px;
}

.day {
	float: left;
	width: 200px;
	height: 45px;
	margin-left: 20px;
	background-color: orange;
}

#search {
	width: 800px;
	height: 90px;
	background-color: orange;
}
</style>
<script type="text/javascript">

</script>
</head>

<body>
	<div id="search">
		<s:form>
		添加新的用户：<s:textfield value="输入用户ID或用户名"></s:textfield>
		<s:submit value="搜索"></s:submit>
		</s:form>
	</div>
	<div class="friedns">
		<div class="headpic"></div>
		<div class="act"></div>
		<div class="day"></div>
	</div>
</body>
</html>
