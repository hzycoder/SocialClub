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

<title>My JSP 'blog.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#research {
	background-color: #FFFFFF;
}

#blogList {
	
}
</style>
</head>

<body>
	<div id="research">
		<s:property value="#session.SUBSUCCESS" />
		<s:if test="hasFieldError"></s:if>
		<s:fielderror />
		<s:form>
 	 搜索我的博文:<s:textfield name="key" />
		</s:form>
		<a href="blogEdit.jsp">写新的文章</a>
	</div>
	
	<div id="blogList">
	<a>博文列表</a>
		<s:action name="showBlogAction" namespace="/" ></s:action>
		<ul>
			<s:iterator value="#session.blogLists">
				<li><s:property value="content" /></li>
			</s:iterator>
		</ul>
	</div>
</body>
</html>
