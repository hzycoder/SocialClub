<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#index {
	background-image: url("image/index-back.jpg");
	background-repeat: no-repeat;
	background-attachment: scroll;
	background-size: 100% auto; /*横向拉伸*/
	width: 100%;
	height: 100%;
	width: 100%;
}

#title {
	color: white;
	position: absolute;
	left: 280px;
	top: 200px;
	position: absolute;
}

#title h1 {
	font-size: 90px;
	font-family: "jubilat-n6", "jubilat", sans-serif;
}

#title span {
	font-size: 45px;
	font-family: 'AvenirLT-Book', 'Helvetica Neue', Helvetica, Arial,
		sans-serif;
}
/*
.btn {
	font-family: 'aileronthin' arial !important;
	letter-spacing: .6px;
	font-size: 16px;
	-webkit-font-smoothing: subpixel-antialiased;
	-webkit-transition: border .25s linear, color .25s linear,
		background-color .25s linear;
	transition: border .25s linear, color .25s linear, background-color .25s
		linear
}

.btn-block {
	display: block;
	width: 100%;
}

.btn-primary.btn-icon {
	position: relative;
	padding-right: 39px;
	border: 0
}

.btn-primary {
	color: #fff;
	border: none;
	border-radius: 0;
}

.btn-lg, .btn-group-lg>.btn {
	padding: 10px 16px;
	font-size: 18px;
	line-height: 1.3333333;
	border-radius: 6px;
}
.btn-success {
  color: #fff;
  background-color: #5cb85c;
  border-color: #4cae4c;
}
.btn-primary {
	color: #fff;
	background-color: #337ab7;
	border-color: #2e6da4;
}*/
button {
	-webkit-appearance: none;
	-webkit-font-smoothing: subpixel-antialiased;
	-webkit-user-select: none;
	align-items: flex-start;
	background-color: rgb(92, 184, 92);
	background-image: none;
	border-bottom-color: rgb(255, 255, 255);
	border-bottom-left-radius: 0px;
	border-bottom-right-radius: 0px;
	border-bottom-style: none;
	border-bottom-width: 0px;
	border-image-outset: 0px;
	border-image-repeat: stretch;
	border-image-slice: 100%;
	border-image-source: none;
	border-image-width: 1;
	border-left-color: rgb(255, 255, 255);
	border-left-style: none;
	border-left-width: 0px;
	border-right-color: rgb(255, 255, 255);
	border-right-style: none;
	border-right-width: 0px;
	border-top-color: rgb(255, 255, 255);
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
	border-top-style: none;
	border-top-width: 0px;
	box-sizing: border-box;
	color: rgb(255, 255, 255);
	cursor: pointer;
	display: block;
	font-family: aileronthin, arial;
	font-size: 16px;
	font-stretch: normal;
	font-style: normal;
	font-variant: normal;
	font-weight: normal;
	height: 41px;
	letter-spacing: 0.6px;
	line-height: 21.3333px;
	margin-bottom: 0px;
	margin-left: 0px;
	margin-right: 0px;
	margin-top: 0px;
	overflow-x: visible;
	overflow-y: visible;
	padding-bottom: 10px;
	padding-left: 16px;
	padding-right: 39px;
	padding-top: 10px;
	position: relative;
	text-align: center;
	text-indent: 0px;
	text-rendering: auto;
	text-shadow: none;
	text-transform: none;
	touch-action: manipulation;
	transition-delay: 0s, 0s, 0s;
	transition-duration: 0.25s, 0.25s, 0.25s;
	transition-property: border, color, background-color;
	transition-timing-function: linear, linear, linear;
	vertical-align: middle;
	white-space: nowrap;
	width: 95px;
	word-spacing: 0px;
	writing-mode: lr-tb;
	-webkit-writing-mode: horizontal-tb;
}
</style>
</head>

<body>
	<div id="index">
		<div id="title">
			<span>Personal blog</span>
			<h1>校园交友网站</h1>
		</div>

		<div class="col-xs-2">
			<button type="button"
				class="btn btn-block btn-lg btn-success btn-icon">
				Accept<i class="fa fa-check-square-o"></i>
			</button>
		</div>



	</div>

</body>
</html>
