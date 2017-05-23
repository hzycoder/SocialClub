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
	height: auto;
	backround-color: pink;
	display: block;
}

#find {
	width: 800px;
	height: 45px;
	background-color: #CCDDCC;
	text-align: center;
	padding: 22.5px;
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
	width: 40px;
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

#search {
	width: 800px;
	height: 90px;
	background-color: orange;
}
</style>
<script type="text/javascript">
	function showFind() {
		var findObj = document.getElementById("find");
		var friObj = document.getElementById("friends");
		findObj.style.display = 'block';
		friObj.style.display = 'none';
	}
	function showFri() {
		var findObj = document.getElementById("find");
		var friObj = document.getElementById("friends");
		findObj.style.display = 'none';
		friObj.style.display = 'block';
	}
</script>
</head>

<body>
	<div id="search">
		<s:form action="logAction!findFriend.action" method="post"
			namespace="/">
		添加新的用户：<s:textfield name="friendString" value="100"></s:textfield>
			<s:submit value="搜索"></s:submit>
		</s:form>
	</div>
	<s:a onclick="showFri()">返回好友列表</s:a>

	<div id="find">
		<div class="headpic">find头像</div>
		<div class="name">
			<s:property value="user.username"></s:property>
		</div>
		<div class="act">最近动态</div>
		
<a href="beFriendAction?username=$('#name').text();">添加为好友</a>
	</div>

	<div id="friends">
		<h1>123ddd</h1>
		<ul>
			<s:iterator value="#session.userList">
				<li>
					<div class="friend">
						<div class="headpic">friend头像</div>
						<div class="name">
							<s:property value="user.username"></s:property>
						</div>
						<div class="act">最近动态</div>
						<div class="day">交友时长</div>
					</div>
				</li>
			</s:iterator>
		</ul>
	</div>
</body>
</html>
