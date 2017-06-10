<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
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

<title>My JSP 'blogContent.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	padding: 0 70px;
}

#title {
	padding: 5px;
	margin: 20px;
	margin-bottom: 0px;
}

a, a:VISITED {
	color: black;
	text-decoration: none;
}

a:HOVER {
	text-decoration: underline;
}

#back {
	float: right;
	margin-right: 80px;
}

#back ul {
	list-style: none;
}

#back ul li {
	margin-left: 10px;
	float: right;
}

input {
	background-color: white;
	color: gray;
	border: 1px black groove;
}

#content {
	width: inherit;
	height: auto;
	border-top: 1px gray dashed;
	border-bottom: 1px gray dashed;
	margin: 20px;
	padding: 15px 50px 80px 5px;
	word-wrap: break-word;
}

pre {
	font-family: "宋体";
	font-size: 16px;
	line-height: 24px;
	white-space: -moz-pre-wrap; /* mozilla, since 1999 */
	white-space: -pre-wrap; /* opera 4-6 */
	white-space: -o-pre-wrap; /* opera 7 */
	word-wrap: break-word; /* internet explorer 5.5+ */
	overflow: auto;
	word-break: break-all;
	word-wrap: break-word;
	white-space: pre-wrap;
}

#time {
	margin-left: 25px;
	margin-bottom: 50px;
	color: gray;
}

h2 {
	margin-bottom: 0px;
}

#ul {
	padding: 30px;
	width: 90%;
	height: 140px;
	border: 1px black solid;
	display: block;
	position: relative;
}

#ul_left {
	position: absolute;
	display: block;
	float: left;
	width: 15%;
	height: 100%
}

#ul_right {
	left: 20%;
	position: absolute;
	display: block;
	float: right;
	width: 83%;
	height: 100%;
}

#commentPic {
	background-color: white;
	margin-bottom: 15px;
}

#commentName {
font-family:"黑体";
color:gray;
	top: 120px;
	left:20px;
}

#commentDetail {
	width: 90%;
}

#commentTime {
	
}

#commentList {
display:block;
margin-bottom:30px;
	width: 100%;
	height: 1080px;
}

#page {
	display: block;
	margin: 10px 0;
	margin-right: 80px;
	float: right;
}
</style>
<script type="text/javascript">
	function filter() {
		var result = document.getElementById("content").innerHTML;

		result = result.replace(/!y9_!/g, "<br/>");
		document.getElementById("content").innerHTML = result;

	}
</script>
</head>
<body style="width: 85%" onload="filter()">
	<s:iterator value="blogShowLists" var="blog">
		<div id="title">
			<h2>
				<s:property value="#blog.title" />
			</h2>
		</div>
		<div id="back">
			<ul>
				<li><a href="showBlogAction"><input type="button"
						value="《《返回博文列表"></a></li>
				<s:if test="#session.friend!=null">
				</s:if>
				<s:else>
					<li><a
						href="showBlogAction!deleteBlog?blogId=<s:property value="#blog.blogId" />"><input
							type="button" value="删除博文"></a></li>
				</s:else>
			</ul>
		</div>
		<div id="time">
			<s:property value="#blog.blogTime" />
		</div>
		<div id="content">
			<pre>
				<s:property value="#blog.content" />
			</pre>
		</div>
		<div id="commentList">
			<span>评论区域</span>
			<s:iterator value="blogCommentList" var="cList">
				<div id="ul">
					<div id="ul_left">

						<s:if test="cList.TUser.UPicture==null">
							<div id="commentPic">
								<img src="upload/defalut.jpg" width="90px" />
							</div>
						</s:if>
						<s:elseif test="blogCommentList.size()!=0">
							<div id="commentPic">
								<img
									src="upload/<s:property value="#cList.TUser.username"/>/<s:property value="#cList.TUser.UPicture"/>"
									width="90px" />
							</div>
						</s:elseif>
						<!-- TUser取消使用延迟加载 -->
						<div id="commentName">
							昵称：<s:property value="#cList.TUser.petname" />
						</div>
					</div>

					<div id="ul_right">
					<div id="reply"  >
					<a>回复</a>
					</div>
						<div id="commentDetail">
							:
							<s:property value="#cList.commentDetail" />
						</div>
						<div id="commentTime">
							<s:date name="#cList.commentTime" />
						</div>
					</div>
				</div>
			</s:iterator>
			<div id="page">
				<a
					href="showBlogAction!showContent?blogId=<s:property value="#blog.blogId" />&pageIndex=1">首页</a>
				<a
					href="showBlogAction!showContent?blogId=<s:property value="#blog.blogId" />&pageIndex=<s:property value='pageIndex-1'/>">上一页</a>
				<a
					href="showBlogAction!showContent?blogId=<s:property value="#blog.blogId" />&pageIndex=<s:property value='pageIndex+1'/>">下一页</a>
				<a
					href="showBlogAction!showContent?blogId=<s:property value="#blog.blogId" />&pageIndex=<s:property value='pageCount'/>">尾页</a>
				<s:property value="pageIndex" />
				/
				<s:property value="pageCount" />
			</div>
		</div>

		<div id="commentArea">
			<s:form action="showBlogAction!comment" method="post">
				<s:textarea name="commentDetail" label="评论" />
				<input type="hidden" name="blogId"
					value=<s:property value="#blog.blogId" />>
				<s:submit value="评论"></s:submit>
			</s:form>
		</div>

	</s:iterator>
</body>
</html>
