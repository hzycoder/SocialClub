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
#back ul li{
	float: right;
	margin-left: 10px;
}
input{
background-color: white;
color: gray;
border: 1px black groove;
}
#content {
	width: inherit;
	height: auto;
	border-top: 1px gray dashed;
	margin: 20px;
	padding: 15px 50px 0 5px;
	word-wrap: break-word;
}

pre {
	font-family: "宋体";
	font-size: 16px;
	line-height: 20px;
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
</style>
<script type="text/javascript">
	function filter() {
		var result = document.getElementById("content").innerHTML;
		result = result.replace(/!y9_!/g, "<br>");
		document.getElementById("content").innerHTML = result;
	}
</script>
</head>
<body style="width: 90%" onload="filter()">
	<div id="title">
		<h2>
			<s:property value="titleString" />
		</h2>
	</div>
	<div id="back">
		<ul>
			<li><a href="showBlogAction"><input type="button"
					value="《《返回博文列表"></a></li>

			<li><a
				href="showBlogAction!deleteBlog?blogId=<s:property value="blogId"/>"><input
					type="button" value="删除博文"></a></li>
		</ul>

	</div>
	<div id="time">
		<s:property value="timeString" />
	</div>
	<div id="content">
		<pre>
			<s:property value="contentString" />
		</pre>
	</div>
</body>
</html>
