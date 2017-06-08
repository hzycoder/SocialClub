<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'personalInfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
 #mytable {
	margin: 0;
	padding: 0;
	border-collapse: collapse;
	   
}

td {
	border: 1px solid #C1DAD7;
	background: #fff;
	font-size: 11px;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
	   
	   
}
</style>


</head>

<body>
	<s:if test="userList.size()!=0">

		<s:if test="#session.friend!=null">

		</s:if>
		<s:else>
			<div style="text-align: right">
				<s:a action="recheckAction">
					<button>修改个人信息</button>
				</s:a>
			</div>
		</s:else>

		<table id="mytable" border="1" width="100%">
			<s:iterator value="userList" var="user">

				<s:if test="#session.friend!=null">
				</s:if>
				<s:else>
					<tr>
						<s:if test="#user.UPicture==null">
							<td colspan="2"><img style="margin:10px"
								src="upload/defalut.jpg" width="100px" height="100px" /> <s:form
									action="infoAction!modifyPhoto.action" method="post"
									theme="simple" enctype="multipart/form-data">
									<s:file name="upload"></s:file>
									<s:submit></s:submit>
								</s:form></td>
						</s:if>
						<s:else>
							<td colspan="2"><img style="margin:10px"
								src="upload/<s:property value="#user.username"/>/<s:property value="#user.UPicture"/>"
								width="100px" height="100px" /> <s:form
									action="infoAction!modifyPhoto.action" method="post"
									namespace="/" theme="simple" enctype="multipart/form-data">
									<s:file name="upload"></s:file>
									<s:submit></s:submit>
								</s:form></td>
						</s:else>
					</tr>
				</s:else>
				<tr>
					<td>用户名：<s:property value="#user.username"></s:property></td>
					<td>昵称：<s:property value="#user.petname" /></td>
				</tr>
				<tr>
					<td>生日：<s:date name="#user.birthday" format="yyyy-MM-dd" /></td>
					<td>所在单位：<s:property value="#user.college" /></td>
				</tr>
				<tr>
					<td colspan="2">联系电话:<s:property value="#user.phone" /></td>
				</tr>
			</s:iterator>
		</table>
		<s:else>暂无数据</s:else>
	</s:if>
</body>
</html>
