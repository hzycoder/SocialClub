<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>
    <s:iterator value="userList" var="user">
    <s:form action="infoAction!modify.action" method="post" theme="simple">
    昵&nbsp;&nbsp;称：<s:textfield name="user.petname" value="%{#user.petname}"></s:textfield></br>
    生&nbsp;&nbsp;日：<s:textfield name="user.birthday">
    <s:param name="value"> <s:date name="#user.birthday" format="yyyy-MM-dd"></s:date></s:param>
    </s:textfield></br>
  所在单位：<s:textfield name="user.college" value="%{#user.college}"></s:textfield></br>
  电&nbsp;&nbsp;话：<s:textfield name="user.phone" value="%{#user.phone}"></s:textfield></br>
  <s:submit ></s:submit>
    </s:form>
    </s:iterator>
    </center>
  </body>
</html>
