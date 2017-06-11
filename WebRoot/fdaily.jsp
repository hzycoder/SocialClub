<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
</style>
  </head>
  
  <body>
  <div>
	<a>动态列表</a>
	<s:action name="showDailyAction?type=0&pageIndex=1"></s:action>
		<ul>
			<s:iterator value="#session.dailyLists">
			<div>
				<li><s:property value="mesg" />
				<s:if test="imgName==null">
					<a>无图片</a>
					</s:if>
					<s:else>
						<br>
						<img height="380px" width="380px" src="upload/<s:property value="imgName"/>"></img>
					</s:else>
				</li>
			</div>
			</s:iterator>
		</ul>
		<br>
		<div id="page">
			<a href="showDailyAction?type=0&pageIndex=1">首页</a>
			<a href="showDailyAction?type=0&pageIndex=<s:property value='pageIndex-1'/>">上一页</a>
			<a href="showDailyAction?type=0&pageIndex=<s:property value='pageIndex+1'/>">下一页</a>
			<a href="showDailyAction?type=0&pageIndex=<s:property value='pageCount'/>">尾页</a>
			<s:property value="pageIndex" />
			/
			<s:property value="pageCount" />
		</div>
	</div>
  </body>
</html>
