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

<title>My JSP 'board.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#board {
	width: 800px;
	height: auto;
	background-color: pink;
	margin: 20px auto;
	border-width: 1px;
	border-style: solid;
	border-color: black;
}

#message {
	text-align: center;
	width: 800px;
	height: auto;
	margin: 0 auto;
	border-width: 1px;
	border-style: solid;
	border-color: black;
	width: 800px;
}

form {
	margin: 20px;
	background: none;
}

textarea {
	background: none;
	margin: 0 auto;
	width: 650px;
	height: 200px;
	margin: 0 auto;
}

li {
	margin: 5px;
}

#mesPic {
	float: left; width : 45px;
	height: 45px;
	background-color: white;
	width: 45px;
}

#mesName {
	width: 45px;
}

#mesContent {
	float: left;
	width: 450px;
}

#mesTime {
float:right;
width:250px;
	text-align: right;
	font-size: 14px;
}
</style>
</head>

<body>
	<s:property value="#session.LEAVEMESSAGESUCCESS"></s:property>
	<div id="message">
		<s:form id="form" action="boardAction" >
			<s:textarea name="board.messageDetail" label="在此留言"></s:textarea>
			<s:submit value="留言"></s:submit>
		</s:form>
	</div>
	<hr size="3px" color="black" width="800px" align="center">

	<div id="board">
		<s:action name="boardAction!messageList" namespace="/"></s:action>
		<ul>
			<s:iterator value="#session.boardList">
				<li id="mesPic"><img  src="upload/<s:property value="username"/>/<s:property value="UPicture"/>" width="45px" height="45px"/></li>
				<li id="mesContent">：<s:property value="messageDetail" /></li>
				<li id="mesName"><s:property value="username" /></li>
				<li id="mesTime">留言时间：<s:date name="messageTime" /></li>
				<hr size="3px" width="80%" text-align="left" align="left" />
			</s:iterator>
		</ul>
		<a href="boardAction!messageList?pageIndex=1">首页</a> <a
			href="boardAction!messageList?pageIndex=<s:property value='pageIndex-1'/>">上一页</a>
		<a
			href="boardAction!messageList?pageIndex=<s:property value='pageIndex+1'/>">下一页</a>
			<s:property value="pageIndex"/>/<s:property value="pageCount"/>
	</div>
</body>
</html>
