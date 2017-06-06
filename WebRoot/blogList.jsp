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
	float:right;
	background-color: #FFFFFF;
}

a {
	text-decoration: none;
}

a:HOVER {
	text-decoration: underline;
}

a, a:VISITED {
	color: black;
}

#blogList li {
	padding: 30px;
	padding-top: 5px;
	border-bottom: 1px black dashed;
	list-style: none;
}

#blogList {
	text-indent: 20px;
}

#blogList p {
	text-overflow: ellipsis; /*截断过长字符*/
	white-space: nowrap;
	overflow: hidden;
	font-family: "宋体";
	text-indent: 20px;
}

#blogTime {
	width: 250px;
	font-size: 14px;
	color: gray;
}

h3 {
	margin-bottom: 0px;
}

#blogContent {
	margin-top: 35px;
}

#page {
	float: right;
}
</style>
<script type="text/javascript">
	function filter() {
		var result = document.getElementById("blogContent").innerHTML;
		result =  result.replace(/!y9_!/g, "");
		document.getElementById("blogContent").innerHTML = result;
	}
</script>
</head>

<body onload="filter()">
	<div id="blogList">
		<span style="color:gray;float:left:display:block;">所有博文(<s:property
				value="#session.uc.blogCount" />)
		</span>
		<input type="button" value="写新的文章" onclick="window.location.href='blogEdit.jsp'">
		<div id="research">
			<s:property value="#session.SUBSUCCESS" />
			<s:if test="hasFieldError"></s:if>
			<s:fielderror />
			<s:form>
 	 <s:textfield name="key" label="搜索" placeholder="输入文章关键字"/>
			</s:form>
		</div>
		<ul>
			<s:iterator value="blogShowLists" var="blog">
				<li>
					<!-- 博文标题 -->
					<div id="blogTitle">
						<a
							href="showBlogAction!showContent?titleString=<s:property value="title"/>&contentString=<s:property value="content"/>&timeString=<s:date name="#blog.blogTime" />"><h3>
								<s:property value="#blog.title" />
							</h3> </a>
					</div> <!-- 博文时间 -->
					<div id="blogTime">
						<s:date name="#blog.blogTime" />
					</div> <!-- 博文内容 -->
					<div id="blogContent">
						<p>
							<s:property value="#blog.content" />
						</p>
					</div>
					<div style="margin-top: 8px;">
						<a style="font-size: 12px;"
							href="showBlogAction!showContent?titleString=<s:property value="title"/>&contentString=<s:property value="content"/>">阅读全文>>
						</a>
					</div>
				</li>
			</s:iterator>
		</ul>
		<div id="page">
			<a href="showBlogAction?pageIndex=1">首页</a> <a
				href="showBlogAction?pageIndex=<s:property value='pageIndex-1'/>">上一页</a>
			<a href="showBlogAction?pageIndex=<s:property value='pageIndex+1'/>">下一页</a>
			<a href="showBlogAction?pageIndex=<s:property value='pageCount'/>">尾页</a>
			<s:property value="pageIndex" />
			/
			<s:property value="pageCount" />
		</div>
	</div>

	

</body>
</html>
