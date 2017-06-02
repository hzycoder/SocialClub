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

<title>My JSP 'homePage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#contain {
	margin: 0 auto;
	width: 1070px;
}

#top {
	margin: 0 auto;
	width: 1070px;
	height: 150px;
	background-color: gray;
	padding: 40px;
}

#head_pic {
	width: 140px;
	height: 140px;
	float: left;
	background-color: #EFEFEF;
}

#petName {
	float: left;
	width: 200px;
	height: 30px;
	margin-left: 30px;
	background-color: #EFEFEF;
}

#menu {
	position: absolute;
	top: 158px;
	left: 605px;
	width: 500px;
	height: 30px;
	background-color: #EFEFEF;
}

#bottom {
	width: 1130px;
	height: 1200px;
	padding: 10px;
	background-color: #EEFFFF;
}

#left {
	float: left;
	width: 240px;
	height: inherit;
	background-color: #FFEEFF;
}

#left_frame {
	border: #000000 0px solid;
	float: left;
	width: 240px;
	height: inherit;
}

#right {
	float: right;
	width: 870px;
	height: inherit;
	background-color: #FFFFEE;
}

#right_frame {
	border: #000000 0px solid;
	float: right;
	width: 870px;
	height: inherit;
}

#act_list td {
	padding: 0px;
	margin: auto;
	height: 120px;
	width: 700px;
	background-color: white;
}

.act_headpic {
	float: left;
	position: relative;
	left: 20px;
	top: -25px;
	height: 45px;
	width: 45px;
	background-color: orange;
	position: relative;
}

.act_petname {
	float: left;
	position: relative;
	left: 55px;
	top: -25px;
	height: 35px;
	width: 160px;
	background-color: orange;
	position: relative;
}

#frm {
	
}

#frm iframe {
	
}

#nav {
	margin: 0 auto;
	width: 100%;
	height: 40px;
	border: #000000 0px solid;
	background-image: url("image/nav_background.jpg");
	margin: 0 auto;
}

#nav_logo {width：auto;
	
}

#nav_name {
	font-size: 18px;
	padding: 10px;
}

#logOff {
	cursor: hand;
	width: 16px;
	height: 16px;
	background-image: url("image/icon.png");
	background-position: -562px -52px;
	margin-top: 13px;
}

li {
	vertical-align: middle;
	margin-right: 10px;
	float: left;
}

body {
	
	/*background-image: url("image/background.jpg");*/
	/*background-repeat: repeat-y;*/
	
}
</style>
</head>
<body>
	<div id="nav">
		<ul>
			<li id="nav_logo"><img alt="logo" src="image/nav_logo.png"
				height="40px"></li>
			<li id="nav_name">
				<div>
					欢迎你！
					<s:property value="#session.user.username" />
				</div>
			</li>
			<li id="logOff"
				onclick="javascript:document.getElementById('logOffA').click();"><a
				id="logOffA" href="logOffAction" target="_parent"></a></li>

		</ul>
	</div>
	<s:action name="clearFriAction" namespace="/"></s:action>
	<div id="contain">
		<!-- Top部分 -->
		<div id="top">

			<div id="head_pic">
				<img  src="upload/<s:property value="#session.user.username"/>/<s:property value="#session.user.UPicture"/>" width="140px" height="140px"/>
			</div>
			<div id="petName">
				昵称
				<s:property value="#session.user.username"></s:property>
			</div>
			<div id="menu">
				<table>
					<tr>
						<td><a href="main.jsp" target="right_frame">主页</a></td>
						<td><a href="clearFriAction?type=1" target="right_frame">博文</a></td>
						<td><a>个人动态</a></td>
						<td><a href="clearFriAction?type=3" target="right_frame">留言板</a></td>
						<td><a href="friends.jsp" target="right_frame">我的好友</a></td>
						<td><s:a action="infoAction" target="right_frame">个人档案</s:a></td>
					</tr>
				</table>
			</div>
		</div>

		<hr width="1070px" color="red">
		<!-- Bottom部分 -->
		<div id="bottom">
			<!-- Left部分 -->
			<div id="left">
				<iframe id="left_frame" name="left_frame" src="left.jsp"></iframe>
			</div>
			<!-- Right部分 -->
			<div id="right">
				<iframe id="right_frame" name="right_frame" src="right.jsp"></iframe>
			</div>
		</div>
	</div>
</body>
</html>
