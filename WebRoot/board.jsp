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
	width: 90%;
	height: auto;
	margin-left: 15px;
}

#content {
	padding: 20px;
}

#message {
	padding-top: 30px;
	display: block;
	margin-top: 40px;
	text-align: center;
	width: 100%;
	height: auto;
	margin: 0 auto;
}

form {
	width: 100%;
	margin: 20px;
	background: none;
}

textarea {
	background: none;
	width: 280%;
	height: 200px;
	margin: 0 auto;
}

li {
	margin: 5px;
}

#mesPic {
	float: left;
	height: 45px;
	background-color: white;
	width: 45px;
	margin-bottom: 15px;
}

#mesName {
	width: 45px;
}

#mesContent {
	float: left;
	width: 450px;
}

#mesTime {
	float: right;
	width: 250px;
	text-align: right;
	font-size: 14px;
}

ul {
	width: 90%;
	height: 110px;
	list-style-type: none;
	border-bottom: 1px dotted black;
	padding-bottom: 5px;
}

#page {
	display: block;
	margin: 10px 0;
	margin-right: 80px;
	float: right;
}

#nothing {
	width: 200px;
	height: 39px;
	padding-top: 30px;
	margin: 0 auto;
	font-size: 30px;
	font-family: arial, "Hiragino Sans GB", "Microsoft Yahei", sans-serif;
}
</style>
</head>

<body>

	<s:property value="#session.LEAVEMESSAGESUCCESS"></s:property>
	<div id="board">
		<span style="color:gray;float:left:display:block;">所有留言(<s:property
				value="#session.uc.messageCount" />)
		</span>
		<s:if test="#session.uc.messageCount==0">
			<div id="nothing">这里空空如也~</div>
		</s:if>
		<s:else>
			<div id="content">
				<s:iterator value="boardList" var="list">

					<ul>
						<s:if test="UPicture==null">
							<div id="mesPic">
								<img src="upload/defalut.jpg" width="45px" height="45px" />
							</div>
						</s:if>
						<s:else>
							<li id="mesPic"><img
								src="upload/<s:property value="#list.username"/>/<s:property value="#list.UPicture"/>"
								width="45px" height="45px" /></li>
						</s:else>
						<li id="mesContent">：<s:property value="#list.messageDetail" /></li>
						<li id="mesName"><s:property value="#list.username" /></li>
						<li id="mesTime"><s:date name="#list.messageTime" /></li>

					</ul>
				</s:iterator>
			</div>
			<div id="page">
				<a href="boardAction!messageList?pageIndex=1">首页</a> <a
					href="boardAction!messageList?pageIndex=<s:property value='pageIndex-1'/>">上一页</a>
				<a
					href="boardAction!messageList?pageIndex=<s:property value='pageIndex+1'/>">下一页</a>
				<a
					href="boardAction!messageList?pageIndex=<s:property value='pageCount'/>">尾页</a>
				<s:property value="pageIndex" />
				/
				<s:property value="pageCount" />
			</div>
		</s:else>
		<div id="message">
			<s:form id="form" action="boardAction">
				<s:textarea name="board.messageDetail" label="在此留言"></s:textarea>
				<s:submit value="留言"></s:submit>
			</s:form>
		</div>
	</div>
</body>
</html>
