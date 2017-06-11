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

<title>fDaily</title>

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

button[type="reset"] {
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

input[type="submit"]:hover, button[type="reset"]:hover {
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
</style>



</head>

<body>

	<div>
		<h1>动态列表</h1>
		<s:action name="showDailyAction?type=0&pageIndex=1"></s:action>
			<s:iterator value="#session.dailyLists">
			<ul>
				<s:form>
					<li><img style="margin:10px"
						src="upload/<s:property value="#session.friend.username"/>/<s:property value="#session.friend.UPicture"/>"
						width="100px" height="100px" /><div class="mesg"><s:property value="mesg" /></div>
					</li>
					<s:if test="imgName==null">
					</s:if>
					<s:else>
						<li><img height="380px" width="380px"
							src="upload/<s:property value="imgName"/>"></img></li>
					</s:else>
					<li id="pn">----<s:property value="#session.friend.petname" /></li>
					<br>
					<li id="mesTime"><s:property value="dailyTime"/></li>
				</s:form>
			</ul>
			</s:iterator>
		<br>
		<center>
			<div id="page">
				<a href="showDailyAction?pageIndex=1&type=0">首页</a>
				<a href="showDailyAction?type=0&pageIndex=<s:property value='pageIndex-1'/>">上一页</a>
				<a
					href="showDailyAction?type=0&pageIndex=<s:property value='pageIndex+1'/>">下一页</a>
				<a
					href="showDailyAction?type=0&pageIndex=<s:property value='pageCount'/>">尾页</a>
				<s:property value="pageIndex" />
				/
				<s:property value="pageCount" />
			</div>
		</center>
	</div>
</body>
</html>
