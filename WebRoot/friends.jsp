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
<script type="text/javascript">
	function deleteConfirm(userName) {
		if (confirm("你确定要删除该好友" + userName + "吗？")) {
			document.getElementById("deleteFriendFrom").action = "beFriendAction!deleteFriend?friendString=" + userName;
			document.getElementById("deleteFriendFrom").submit();
		}
	}
</script>
</head>

<body>

	<a href="findFriend.jsp" target="middle_frame">查询用户</a>
	<div id="friends">
		<!-- 好友列表 -->
		<s:action name="beFriendAction" namespace="/"></s:action>
		<ul>
			<s:iterator value="#session.friInfoList">
				<li><s:if test="UPicture==null">
						<div class="headpic">
							<img src="upload/defalut.jpg" width="45px" height="45px" />
						</div>
					</s:if> <s:else>
						<div class="headpic">
							<img
								src="upload/<s:property value="username"/>/<s:property value="UPicture"/>"
								width="45px" height="45px" />
						</div>
					</s:else>
					<div class="name" id="friendName">
						<a href="friAction?friendName=<s:property value='username'/>"
							target="_top"><s:property value="username"></s:property></a>
					</div>
					<div class="day">
						关注好友已经：
						<s:property value="friendTime"></s:property>
						天
					</div>
					<div>
						<form id="deleteFriendFrom" action="" method="post"></form>
						<input type="button" value="删除好友"
							onclick="deleteConfirm('<s:property value='username'/>')">
					</div></li>
			</s:iterator>
		</ul>
	</div>
</body>
</html>
