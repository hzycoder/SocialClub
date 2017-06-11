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

<title>My JSP 'showNoticeDetail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#petname {
	text-decoration: underline;
}

#detail {
	line-height: 1.4;
	font-size: 23px;
	font-weight: 200;
	width: 90%;
	margin: 0 auto;
	margin-top: 50px;
	text-align: center;
}

#back {
	padding-top: 25px;
	margin: 0 auto;
	width: 125px;
}
</style>
</head>

<body>
	<s:if test="notice.noticeType==1">
		<div id="detail">
			<a
				href="friAction?friendName=<s:property value='notice.TUserBySenderId.username'/>"
				target="_top" id="petname"><s:property
					value="notice.TUserBySenderId.petname" /></a>刚刚关注了你！你的粉丝又增加了一位 !<br>
			<div id="back">
				<a href="noticeAction!showNotice"><input type="button"
					value="《《返回通知列表"></a>
			</div>

		</div>
	</s:if>
	<s:else>
		<div id="detail">
			<a
				href="friAction?friendName=<s:property value='notice.TUserBySenderId.username'/>"
				target="_top" id="petname"><s:property
					value="notice.TUserBySenderId.petname" /></a>刚刚评论了你的博文《
			<s:property value="notice.noticeContent" />
			》，赶紧去看看吧！ <br>
			<div id="back">
				<a id="back" href="noticeAction!showNotice"><input type="button"
					value="《《返回通知列表"></a>
			</div>

		</div>
	</s:else>

</body>
</html>
