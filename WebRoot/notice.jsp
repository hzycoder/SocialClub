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

<title>My JSP 'notice.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
a:HOVER {
	text-decoration: underline;
}

a, a:VISITED {
	text-decoration: underline;
	color: black;
}
</style>
</head>

<body>
	<s:iterator value="noticeList">
		<div id="notice">
			<s:if test="noticeType==1">
				<s:if test="noticeState==1">
					<div id="title">
						<a style="color:gray;text-decoration:none;"
							href="noticeAction!showNoticeDetail?noticeID=<s:property value="noticeId"/>">您有一个新的粉丝！</a>
					</div>
				</s:if>
				<s:if test="noticeState==0">
					<div id="title" style="font-family:'黑体';">
						<a
							href="noticeAction!showNoticeDetail?noticeID=<s:property value="noticeId"/>">您有一个新的粉丝！</a>
					</div>
				</s:if>
				<div>
					<s:date name="noticeTime" />
				</div>
			</s:if>
			
			<s:if test="noticeType==2">
				<s:if test="noticeState==1">
					<div id="title">
						<a style="color:gray;text-decoration:none;"
							href="noticeAction!showNoticeDetail?noticeID=<s:property value="noticeId"/>">您收到一条新评论！</a>
					</div>
				</s:if>
				<s:if test="noticeState==0">
					<div id="title" style="font-family:'黑体';">
						<a
							href="noticeAction!showNoticeDetail?noticeID=<s:property value="noticeId"/>">您收到一条新评论！</a>
					</div>
				</s:if>
				<div>
					<s:date name="noticeTime" />
				</div>
			</s:if>
			
		</div>
	</s:iterator>



	<div id="page">
		<a href="noticeAction?pageIndex=1">首页</a> <a
			href="noticeAction?pageIndex=<s:property value='pageIndex-1'/>">上一页</a>
		<a href="noticeAction?pageIndex=<s:property value='pageIndex+1'/>">下一页</a>
		<a href="noticeAction?pageIndex=<s:property value='pageCount'/>">尾页</a>
		<s:property value="pageIndex" />
		/
		<s:property value="pageCount" />
	</div>
</body>
</html>
