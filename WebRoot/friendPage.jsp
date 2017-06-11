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

<title>My JSP 'friendPage.jsp' starting page</title>

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

#parent {
	margin-bottom: 15px;
}

#parent li {
	list-style: none;
	margin-bottom: 15px;
}

#parent li:HOVER {
	background-color: #f0f0f0;
}

#parent1 li {
	list-style: none;
	margin-bottom: 15px;
}

#parent1 {
	
}

#parent1 li:HOVER {
	background-color: #f0f0f0;
}
#divpop img {
	border-radius: 50%;
}
button {
	float: right;
	position: relative;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.1.min.js">
	</script>
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
		})
	})
	function deleteConfirm(userName) {
		if (confirm("你确定要取消关注" + userName + "吗？")) {
			document.getElementById("deleteFriendFrom").action = "beFriendAction!deleteFriend?friendString=" + userName;
			document.getElementById("deleteFriendFrom").submit();
		}
	}
	window.onload = function jump() {
		var ref = document.referrer;
	}
	function openShutManager(oSourceObj, oTargetObj, shutAble, oOpenTip, oShutTip) {
		var sourceObj = typeof oSourceObj == "string" ? document.getElementById(oSourceObj) : oSourceObj;
		var targetObj = typeof oTargetObj == "string" ? document.getElementById(oTargetObj) : oTargetObj;
		var openTip = oOpenTip || "";
		var shutTip = oShutTip || "";
		if (targetObj.style.display != "none") {
			if (shutAble) return;
			targetObj.style.display = "none";
			if (openTip && shutTip) {
				sourceObj.innerHTML = shutTip;
			}
		} else {
			targetObj.style.display = "block";
			if (openTip && shutTip) {
				sourceObj.innerHTML = openTip;
			}
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
		style="background-color: #ffffff; border: solid 1px #000000; position: fixed; display: none;
	width: 350px;height: 100%; overflow: scroll;  
	">
		<s:action name="beFriendAction" namespace="/"></s:action>
		 <a href="findFriend.jsp" target="middle_frame"><img
			src="image/timg.jpg" width="25px" height="25px"></a>搜索好友    

		<!-- 关注好友列表 -->

		<div id="parent" style="width: 100%; ">
			<button style="float: right;"
				onclick="openShutManager(this,'child',false,'我关注的#关闭','我关注的#展开')">我关注的#关闭</button>
			<div id="child" style="padding: 18px 47px 20px 27px;">
				<s:iterator value="#session.friInfoList">
					<li>
					<a href="friAction?friendName=<s:property value='user_friList.username'/>"
						target="_top">
						<s:if test="user_friList.UPicture==null">
								<img src="upload/defalut.jpg" width="45px" height="45px" />
						</s:if> 
						<s:else>
								<img src="upload/<s:property value="user_friList.username"/>/<s:property value="user_friList.UPicture"/>"
									width="45px" height="45px" />
						</s:else>
					</a> 
					<s:property value="friInfoList.petname"></s:property>
						<div>
							<form id="deleteFriendFrom" action="" method="post"></form>
							<input type="button" value="取消关注"
								onclick="deleteConfirm('<s:property value='user_friList.username'/>')"
								style="display:inline-block; float: right;">
						</div>
						<div class="day">
							关注好友已经：
							<s:property value="friendTime"></s:property>
							天
						</div></li>
				</s:iterator>
			</div>
		</div>
		<!-- 关注好友列表 -->
		   
		<!-- 被关注列表 -->
		<div id="parent1" style="width: 100%; ">
			<button style="float: right;"
				onclick="openShutManager(this,'child1',false,'关注我的#关闭','关注我的#展开')">关注我的#关闭</button>
			<div id="child1" style="padding: 18px 47px 20px 27px;">
				<s:iterator value="#session.friInfoList1">
					<li><a
						href="friAction?friendName=<s:property value='user_friList.username'/>"
						target="_top"><s:if test="user_friList.UPicture==null">
								<img src="upload/defalut.jpg" width="45px" height="45px" />
							</s:if> <s:else>
								<img
									src="upload/<s:property value="user_friList.username"/>/<s:property value="user_friList.UPicture"/>"
									width="45px" height="45px" />
							</s:else></a> <s:property value="user_friList.username"></s:property>

						<div class="day">
							ta关注你已经：
							<s:property value="friendTime"></s:property>
							天
						</div></li>
				</s:iterator>
			</div>
		</div>
		<!-- 被关注列表 -->
		   
	</div>
	<!-- 悬浮好友列表 -->
	<div id="contain">
		<!-- Top部分 -->
		<div id="top">
			<!-- 导航栏 -->
			<s:if test="#session.friend.UPicture==null">
				<div id="head_pic">
					<img src="upload/defalut.jpg" width="140px" height="140px" />
				</div>
			</s:if>
			<s:else>
				<div id="head_pic">
					<img
						src="upload/<s:property value="#session.friend.username"/>/<s:property value="#session.user.UPicture"/>"
						width="140px" height="140px" />
				</div>
			</s:else>
			<div id="petName">
				<s:property value="#session.friend.petname"></s:property>
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
				<iframe frameborder="0" id="middle_frame" name="middle_frame" src=""></iframe>
			</div>
			<div id="menu">
				<ul>
					<li><a id="blogA" href="showBlogAction" target="middle_frame"><s:property
								value="#session.friend.username" />的博文</a></li>
					<li><a href="showDailyAction?type=0" target="middle_frame"><s:property
								value="#session.friend.username" />的动态</a></li>
					<li><a href="showBoardAction" target="middle_frame"><s:property
								value="#session.friend.username" />的留言板</a></li>
					<li><s:a id="personA" action="infoAction"
							target="middle_frame">
							<s:property value="#session.friend.username" />的档案</s:a></li>
					<li><a href="clearFriAction?type=2">返回我的主页</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
