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

<title>Daily</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<style type="text/css">
#page {
	float: center;
}

form {
	padding: 3em 2em;
	background: #F2F2F2;
}

form li {
	border: 2px ridge rgba(187, 185, 189, 0.11);
	border-radius: 0.3em;
	-webkit-border-radius: 0.3em;
	-moz-border-radius: 0.3em;
	-o-border-radius: 0.3em;
	list-style: none;
	background: #F0EEF0;
	 border-bottom:none;
}

li {
	border: 2px ridge rgba(187, 185, 189, 0.11);
	border-radius: 0.3em;
	-webkit-border-radius: 0.3em;
	-moz-border-radius: 0.3em;
	-o-border-radius: 0.3em;
	list-style: none;
	background: #F0EEF0;
	float: center;
	border-bottom:none;
}

input[type="submit"] {
	color: #8c96a0;
	font-family: 'Droid Sans', sans-serif;
	width: 20%;
	padding: 0.5em 0em 0.5em 1em;
	font-size: 20px;
	outline: none;
	background: none;
	border: none;
}

button {
	float:right;
	color: #8c96a0;
	font-family: 'Droid Sans', sans-serif;
	width: 30%;
	padding: 0.5em 5em 0.5em;
	font-size: 20px;
	outline: none;
	background: none;
	border: none;
}

input[type="submit"]:hover, button:hover {
	background: #fff;
	color: #6C496F;
	border: 2px solid #6C496F;
}

.h1 {
	color: #fff;
	font-size: 1.5em;
	text-align: left;
	margin: 0 23px;
}

.mesg{
	vertical-align:middle;
	margin:5px;
}

#mesTime {
	float: right;
	border: 2px ridge rgba(187, 185, 189, 0.11);
	border-radius: 0.3em;
	-webkit-border-radius: 0.3em;
	-moz-border-radius: 0.3em;
	-o-border-radius: 0.3em;
	list-style: none;
	background: #F0EEF0;
	border-bottom:none;
}

#pn{
	float:right;
	border: 2px ridge rgba(187, 185, 189, 0.11);
	border-radius: 0.3em;
	-webkit-border-radius: 0.3em;
	-moz-border-radius: 0.3em;
	-o-border-radius: 0.3em;
	list-style: none;
	background: #F0EEF0;
	 border-bottom:none;
}

.f{
		padding: 3em 2em;
	background: #F2F2F2;
}
</style>



</head>

<body>

	<div>
		<s:form action="subDailyAction!execute" namespace="/" method="post"
			enctype="multipart/form-data">
			<li><s:textarea id="text" name="mesg" rows="10" cols="100"></s:textarea></li>
			<hr>
			<li><label for="upload">添加图片</label><input type="file"
				name="upload"
				accept=".jpg,.gig,.png,.tif,.rgb,.dib,.eps,.jpe,.pcx,.bmp,.gif">
			</li>
			<hr>
			<li><s:submit value="发表" /></li>
		</s:form>
	</div>
	<div>
		<h1>动态列表</h1>
		<s:action name="showDailyAction?type=1&pageIndex=1"></s:action>
			<s:iterator value="#session.dailyLists">
			
				<div class="f">
				<ul>
					<li><img style="margin:10px"
						src="upload/<s:property value="#session.user.username"/>/<s:property value="#session.user.UPicture"/>"
						width="100px" height="100px" /><div class="mesg"><s:property value="mesg" /></div>
					</li>
					<s:if test="imgName==null">
					</s:if>
					<s:else>
						<li><img height="380px" width="380px"
							src="upload/<s:property value="imgName"/>"></img></li>
					</s:else>
					<li id="pn">----<s:property value="#session.user.petname" /></li>
					<br>
					<li id="mesTime"><s:property value="dailyTime"/></li>
					<br>
						<li><a href="deleteDailyAction?dailyId=<s:property value="dailyId"/>"><button onclick="return window.confirm('将删除本条动态，你确定要删除吗？')">删除</button></a>
						</li>
						</ul>
				</div>
			
			</s:iterator>
		<br>
		<center>
			<div id="page">
				<a href="showDailyAction?pageIndex=1&type=1">首页</a> <a
					href="showDailyAction?type=1&pageIndex=<s:property value='pageIndex-1'/>">上一页</a>
				<a
					href="showDailyAction?type=1&pageIndex=<s:property value='pageIndex+1'/>">下一页</a>
				<a
					href="showDailyAction?type=1&pageIndex=<s:property value='pageCount'/>">尾页</a>
				<s:property value="pageIndex" />
				/
				<s:property value="pageCount" />
			</div>
		</center>
	</div>
</body>
</html>
