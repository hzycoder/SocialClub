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
.friend {
	width: 800px;
	height: 45px;
	background-color: #CCDDCC;
	text-align: center;
	padding: 22.5px;
}

#friends {
	width: 800px;
	height: 400px;
	background-color: pink;
	display: block;
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
	<a href="findFriend.jsp" target="right_frame">查询用户</a>
	<div id="friends">
		<!-- 好友列表 -->
		<s:action name="beFriendAction" namespace="/"></s:action>
		<ul>
			<s:iterator value="#session.friInfoList">
				<li>
					<div class="headpic">头像</div>
					<div class="name">
						<a href="homePage.jsp" target="_blank"><s:property value="username"></s:property></a>
					</div>
					<div class="day">
						成为好友已经：
						<s:property value="friendTime"></s:property>
						天
					</div>
				</li>
			</s:iterator>
		</ul>
	</div>
</body>
</html>
