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
    
    <title>My JSP 'mainframe.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
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
ul.address-text li {
	display: inline-block;
	margin-top: 1em;
}
ul.address-text li.text {
	display: inline-block;
	margin-top: 1em;
	padding-bottom: 20px;
}
ul.address-text {
	padding: 0px;
}
ul.address-text li:nth-child(1) {
	width: 20%;
}
a:link {
font-size:30px;
 color: #000000;
 text-decoration: none;
}
a:visited {

 color: #000000;
 text-decoration: none;
}
img{
width: 75px;
height: 75px;
border-radius: 50%;
}
</style>
  </head>
  
  <body>
  <s:action name="showDailyAction!showrecent.action" namespace="/"></s:action>
  <div style="margin: 0 auto;width: 60%;margin-top: 30px;">

  
  <s:if test="tdlist.size()!=0">
  <s:iterator value="tdlist" var="td">
  <ul class="address">
  <li>
  <ul class="address-text">
  <li>
  <s:if test="#td.TUser.UPicture!=null">
  <img alt="" src="upload/<s:property value="#td.TUser.username"/>/<s:property value="#td.TUser.UPicture"/>"><br>
  </s:if>
  <s:else>
  <img alt="" src="upload/default.jpg"><br>
  </s:else>
  <s:property value="#td.TUser.petname"/>说：
  </li>
  <li class="text"><s:property value="#td.mesg" ></s:property></li>
  <li style="float: right;"><s:date name="#td.dailyTime" ></s:date></li>
  </ul>
  </li>
  </ul>
  </s:iterator><center>
  <a href="showDailyAction!showrecent.action?pageIndex=<s:property value="pageIndex+1" />" style="text-decoration: none; display: inline-block;"><div style="height: 40px;width: 170px; border-style:solid; border-width:1px; border-color:#000;font-size: 30px"> 换一组</div></a></center>
  </s:if>
  <s:else><center>
  没有更多了</center>
  </s:else>

</div>
</body>
</html>