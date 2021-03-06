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

<title>My JSP 'blogEdit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#blogEdit {
	padding: 30px 50px 0 80px;
	width: 870px;
	height: inherit;
	background-color: #FFFFFF;
	width: 870px;
}

#back {
	float: right;
}

a, a:VISITED {
	color: black;
	text-decoration: none;
}

a:HOVER {
	text-decoration: underline;
}
</style>

</head>

<body>
	<div id="blogEdit">
		<s:form action="showBlogAction!submitBlog" method="post" namespace="/">
			<s:textfield name="titleString" label="标题" size="50"
				placeholder="在这里输入博文标题" autofocus="autofocus" required="required"></s:textfield>
			<div id="back">
				<a href="showBlogAction">《《不保存返回博文列表</a>
			</div>
			<br>
			<s:textarea id="contentString" name="contentString" label="内容"
				cols="100" rows="20" placeholder="博文内容" wrap="hard"
				style="resize:none;"></s:textarea>
			<s:submit value="提交"></s:submit>
		</s:form>
	</div>
</body>
</html>
