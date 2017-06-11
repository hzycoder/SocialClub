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

.header-right {
	padding: 3em;
}

.header-right {
	padding-left: 3em;
}

.header-right h6 {
	font-size: 1em;
}

.col-md-1 {
	width: 40.35%;
}

.col-md-1, .col-md-2 {
	float: right;
}

ul.address {
	margin-top: 2em;
	border-top: 1px solid #000000;
	padding-top: 0.5em;
}

ul.address {
	padding: 0px;
}

ul.address li {
	display: block;
}

ul.address-text {
	padding: 0px;
}

ul.address-text li:nth-child(1) {
	width: 40%;
}

ul.address-text li {
	display: inline-block;
	margin-top: 1em;
}

.header-left {
	padding: 3em;
}

.col-md-2 {
	position: absolute;
	width: 41.66%
}

.col-md-2 img {
	width: 100%;
	margin-top: 39px;
	padding-top: 15px;
}
</style>


</head>

<body>
	<div style="text-align: right">
		<s:a action="recheckAction">
			<button>修改个人信息</button>
		</s:a>
	</div>
	<s:if test="userList.size()!=0">
		<s:iterator value="userList" var="user">
			<div class="show">
				<div class="col-md-1 header-right">
					<h6>个人信息</h6>
					<ul class="address">
						<li>
							<ul class="address-text">
								<li><b>用户名</b></li>
								<li><s:property value="#user.username"></s:property></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>昵称</b></li>
								<li><s:property value="#user.petname"></s:property></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>出生日期</b></li>
								<li><s:date name="#user.birthday" format="yyyy-MM-dd"></s:date></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>邮箱</b></li>
								<li><s:property value="#user.email"></s:property></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>所在大学</b></li>
								<li><s:property value="#user.college"></s:property></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>联系电话</b></li>
								<li><s:property value="#user.phone"></s:property></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="col-md-2 header-left">
					<s:if test="#user.UPicture==null">
						<img alt="" src="upload/default.jpg">
						<s:form action="infoAction!modifyPhoto.action" method="post"
							theme="simple" enctype="multipart/form-data">
							<s:file name="upload"></s:file>
							<s:submit></s:submit>
						</s:form>
					</s:if>
					<s:else>
						<img alt=""
							src="upload/<s:property value="#user.username"/>/<s:property value="#user.UPicture"/>">
						<s:form action="infoAction!modifyPhoto.action" method="post"
							theme="simple" enctype="multipart/form-data">
							<s:file name="upload"></s:file>
							<s:submit cssStyle="float:right"></s:submit>
						</s:form>
					</s:else>
				</div>
			</div>
		</s:iterator>

	</s:if>
	<s:else>服务器正忙</s:else>
</body>
</html>
