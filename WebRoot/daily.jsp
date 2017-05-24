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

  </head>
  
  <body>
    <div>
    	<s:form action="subDailyAction" namespace="/" method="post">
    		<s:textarea id="text" name="mesg" rows="18" cols="65"></s:textarea>
    		<hr>
    		<a href="">添加图片<input type="file" name="file1" id="file1" accept=".jpg,.gig,.png,.tif,.rgb,.dib,.eps,.jpe,.pcx,.bmp,.gif"></a>
    		<hr>
    		<input type="submit" class="" value="发表" />
    	</s:form>
    </div>
  </body>
</html>
