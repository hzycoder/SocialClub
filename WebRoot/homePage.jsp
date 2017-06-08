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
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var speed = 200;
		$("#show").click(function(event) {
			event.stopPropagation();
			var offset = $(event.target).offset();
			$("#divpop").css({
				top : offset.top + $(event.target).top + "px",
				right : $(window).width() - offset.left
			})
			$("#divpop").toggle(speed);
			$(document).click(function(event) {
				$("#divpop").hide(speed);
			})
		})
	})
	function deleteConfirm(userName) {
		if (confirm("你确定要删除该好友" + userName + "吗？")) {
			document.getElementById("deleteFriendFrom").action = "beFriendAction!deleteFriend?friendString=" + userName;
			document.getElementById("deleteFriendFrom").submit();
		}
	}
</script>
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
	text-overflow: ellipsis; /*截断过长字符*/
	white-space: nowrap;
	overflow: hidden;
	font-family: "Microsoft JhengHei";
	font-size: 20px;
	display: block;
	overflow: hidden;
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
.button.gray {
	color: #8c96a0;
	text-shadow: 1px 1px 1px #fff;
	border: 1px solid #dce1e6;
	box-shadow: inset 0px 1px 2px #fff, inset 0px -1px 0px #a8abae;
	background: -moz-linear-gradient(top, #f2f3f7, #e4e8ec);
	background: linear-gradient(top, #f2f3f7, #e4e8ec);
}

.button {
	text-align: center;
	font-weight: bold;
	border-radius: 5px;
	overflow: hidden;
}

.gray:hover {
	background: -webkit-linear-gradient(top, #fefefe, #ebeced);
	background: -moz-linear-gradient(top, #f2f3f7, #ebeced);
	background: linear-gradient(top, #f2f3f7, #ebeced)
}

.gray:active {
	top: 1px;
	box-shadow: 0 1px 3px #a8abae inset, 0 3px 0 #fff;
	background: -webkit-linear-gradient(top, #e4e8ec, #e4e8ec);
	background: -moz-linear-gradient(top, #e4e8ec, #e4e8ec);
	background: linear-gradient(top, #e4e8ec, #e4e8ec)
}
</style>
<script type="text/javascript">
	window.onload = function jump() {
		var ref = document.referrer;
		if (ref == "http://localhost:8080/SocialClub/infoAction!modifyPhoto.action" || ref == "http://localhost:8080/SocialClub/infoAction!modify.action") {
			document.getElementById("personA").click();
		} else if (ref.indexOf("Blog") != -1) {
			document.getElementById("blogA").click();
		}
	}
</script>
</head>
<body>
	<!-- 悬浮好友列表 -->
	<div style="right:1px;
	top:70px;	position: fixed;">
		<button id="show" class="button gray">
			好<br>友<br>列<br>表<br>
		</button>
	</div>
	<div id="divpop"
		style="background-color: #f0f0f0; border: solid 1px #000000; position: fixed; display: none;
	width: 300px;height: 100%; 
	">
		<s:action name="beFriendAction" namespace="/"></s:action>
		 <a href="findFriend.jsp" target="middle_frame"><img
			src="image/timg.jpg" width="25px" height="25px"></a>搜索好友         
		<div style="text-align: center;">
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
		</div>
	</div>
	<!-- 悬浮好友列表 -->
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
					src="main.jsp"></iframe>
			</div>
			<div id="menu">
				<ul>
					<li><a href="main.jsp" target="middle_frame">主页</a></li>
					<li><a id="blogA" href="clearFriAction?type=1"
						target="middle_frame">博文</a></li>
					<li><a>个人动态</a></li>
					<li><a href="clearFriAction?type=3" target="middle_frame">留言板</a>
					</li>
					<li><a id="friendA" href="friends.jsp" target="middle_frame">我的好友</a></li>
					<li><s:a id="personA" action="infoAction"
							target="middle_frame">个人档案</s:a></li>
					<li><a id="logOffA" href="logOffAction" target="_parent">
							<span>注销</span>
					</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
