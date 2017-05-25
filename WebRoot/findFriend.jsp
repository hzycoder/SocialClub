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

<title>My JSP 'findFriend.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#search {
	width: 800px;
	height: 90px;
	background-color: orange;
}

#find {
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

.name {
	float: left;
	width: 50px;
	height: 45px;
	margin-left: 20px;
	background-color: orange;
}

.act {
	float: left;
	width: 400px;
	height: 45px;
	background-color: orange;
}

.day {
	float: left;
	width: 200px;
	height: 45px;
	margin-left: 20px;
	background-color: orange;
}

li {
	margin: 50px;
}
</style>
</head>

<body>
	<div id="search">
		<s:form action="beFriendAction!findFriend.action" method="post"
namespace="/">
		添加新的用户：<s:textfield name="friendString" value="sara"></s:textfield>
			<s:submit value="搜索"></s:submit>
		</s:form>
	</div>


	<a href="friends.jsp" target="right_frame">返回好友列表</a>

	<div id="find">
		<!-- 查找的好友 -->
		<div class="headpic">find头像</div>
		<div class="name">
			<s:property value="friendUser.username"></s:property>
		</div>
		<div class="act">最近动态</div>

		<a
			href="beFriendAction!beFriend.action?friendUser.username=<s:property value='friendUser.username'/>">添加为好友</a>
	</div>
</body>
</html>
