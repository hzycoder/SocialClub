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
	width: 100%;
}

#top {
	margin: 0 auto;
	height: 150px;
	background-image: url("image/top-back.png");
	padding: 40px;
}

#head_pic {
	margin: 0 auto;
	height: 160px;
	width: 160px;
	margin-top: 10px;
}

#head_pic img {
	width: 140px;
	height: 140px;
	border-radius: 50%;
	border: 10px solid #fff;
}

#petName {
	text-align: center;
	font-size: 20px;
	width: 160px;
	height: 28px;
	line-height: 28px;
	background-color: #e2eee7;
	font-family: punctuation, "PingFangSC-Regular", "Microsoft Yahei",
		"sans-serif";
	margin: 10px auto;
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

#nav {
	margin: 0 auto;
	width: 100%;
	height: 40px;
	border: #000000 0px solid;
	background-color: #04b1cc;
	margin: 0 auto;
}

#nav_logo {
	width: auto
}

#nav_name {
	font-size: 18px;
	padding: 10px;
}

#logOffIcon {
	cursor: hand;
	width: 16px;
	height: 16px;
	background-image: url("image/icon.png");
	background-position: -562px -52px;
	margin-top: 13px;
}

#logOFF {
	width: 30px;
	height: auto;
}

#bottom {
	margin-top: 20px;
	width: 100%;
	height: 650px;
}

#left {
	float: left;
	width: 20%;
	height: inherit;
}

#left_frame {
	position: fixed;
	width: 100%;
	height: inherit;
	float: left;
}

#middle {
	float: left;
	width: 58%;
	height: inherit;
	border-left: 1px solid #91d3ba;
	border-right: 1px solid #60a7ba;
	border-top: none;
	border-bottom: none;
	border-top: none
}

#middle_frame {
	width: 100%;
	height: inherit;
}
/*菜单css*/
#menu {
	float: left;
	width: 20%;
	height: inherit;
}

#menu ul {
	
}

#menu li {
	text-align: center;
	width: 70%;
	height: 60px;
	line-height: 60px;
	list-style: none;
	cursor: pointer;
	border: 1px solid #60a7ba;
	margin-bottom: -1px;
}

#menu li:FIRST-CHILD {
	border-top-left-radius: 4px;
	border-top-right-radius: 4px;
}

#menu li:LAST-CHILD {
	margin-bottom: 0;
	border-bottom-right-radius: 4px;
	border-bottom-left-radius: 4px;
}

#menu li a {
	text-overflow: ellipsis;		/*截断过长字符*/
	white-space: nowrap; 
	overflow : hidden;
	font-family: "Microsoft JhengHei";
	font-size: 20px;
	display: block;
	overflow: hidden;
}

a, a:VISITED {
	color: black;
	text-decoration: none;
}

#menu li:hover, #menu li:FOCUS {
	background-color: #7bbcbd;
}
/*菜单CSS*/
/*left_num*/
#left_num {
	width: 100%;
	height: 600px;
}

#left_num ul strong {
	font: 32px/1.5 Tahoma, Helvetica, Arial, '宋体', sans-serif;
	display: block;
}

#left_num ul span {
	font-family: "幼圆";
	display: block;
}

ula {
	width: 70%;
}

#left_num ul li {
	padding: 15px;
	text-align: center;
	margin-bottom: 20px;
	border: 1px solid #91d3ba;
	float: left;
	width: 36%;
	height: 80px;
	list-style: none;
	margin-right: -1px;
	margin-bottom: -1px;
	text-align: center;
}

#left_num ul li:FIRST-CHILD {
	border-top-left-radius: 20px;
}

#left_num ul li:LAST-CHILD {
	border-bottom-right-radius: 20px;
}
/*left_num*/
</style>
</head>
<body>
	<s:action name="clearFriAction" namespace="/"></s:action>
	<div id="contain">
		<!-- Top部分 -->
		<div id="top">
			<!-- 导航栏 -->
			<s:if test="#session.user.UPicture==null">
				<div id="head_pic">
					<img src="upload/defalut.jpg" width="140px" height="140px" />
				</div>
			</s:if>
			<s:else>
				<div id="head_pic">
					<img
						src="upload/<s:property value="#session.user.username"/>/<s:property value="#session.user.UPicture"/>"
						width="140px" height="140px" />
				</div>
			</s:else>
			<div id="petName">
				<s:property value="#session.user.petname"></s:property>
			</div>
		</div>

		<!-- Bottom部分 -->
		<div id="bottom">
			<!-- Left部分 -->
			<div id="left">
				<div id="left_num">
					<ul id="ula">
						<li><strong><s:property
									value="#session.uc.friendCount" /></strong> <span>好友</span></li>
						<li><strong><s:property
									value="#session.uc.blogCount" /></strong> <span>博文</span></li>
						<li><strong><s:property
									value="#session.uc.messageCount" /></strong> <span>留言</span></li>
						<li><strong><s:property value="#session.uc.actCount" /></strong>
							<span>动态</span></li>
					</ul>
				</div>
			</div>
			<!-- middle部分 -->
			<div id="middle">
				<iframe frameborder="0" id="middle_frame" name="middle_frame"
					src="right.jsp"></iframe>
			</div>
			<div id="menu">
				<ul>
					<li><a href="main.jsp" target="middle_frame">主页</a></li>
					<li><a href="clearFriAction?type=1" target="middle_frame">博文</a>
					</li>
					<li><a>个人动态</a></li>
					<li><a href="clearFriAction?type=3" target="middle_frame">留言板</a>
					</li>
					<li><a href="friends.jsp" target="middle_frame">我的好友</a></li>
					<li><s:a action="infoAction" target="middle_frame">个人档案</s:a></li>
					<li><a id="logOffA" href="logOffAction" target="_parent">
							<span>注销</span>
					</a></li>
				</ul>
				<!-- <div id="logOFF"
								onclick="javascript:document.getElementById('logOffA').click();"></div> -->
			</div>
		</div>
	</div>
</body>
</html>
