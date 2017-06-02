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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<meta http-equiv="refresh" content="url=showBlogAction?pageIndex=1">
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#research {
	background-color: #FFFFFF;
}

#blogList {
	
}

#blogTitle {
	
}

#blogContent {
	
}

#blogTime {
	float: right;
	width: 250px;
	text-align: right;
	font-size: 14px;
}

li {
	margin: 5px;
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
		<ul>
			<s:iterator value="blogShowLists" var="blog">
				<div id="blogTitle"><a href="showBlogAction!showContent?titleString=<s:property value="title"/>&contentString=<s:property value="content"/>">标题:<s:property value="#blog.title" /></a></li></div>
				<div id="blogContent"><s:property value="#blog.content" /></div>
				<div id="blogTime">博文时间<s:date name="#blog.blogTime" /></div>
				<hr size="3px" width="80%" text-align="left" align="left" />
			</s:iterator>
		</ul>
		<a href="showBlogAction?pageIndex=1">首页</a> 
		<a href="showBlogAction?pageIndex=<s:property value='pageIndex-1'/>">上一页</a>
		<a href="showBlogAction?pageIndex=<s:property value='pageIndex+1'/>">下一页</a>
		<s:property value="pageIndex" />
		/
		<s:property value="pageCount" />
	</div>
</body>
</html>
