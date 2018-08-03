<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!--设置跳转地址-->
	<script type="text/javascript">
	//创建计时器
    function returnLogin() {
   			var time = 4;
    		setInterval(function() {
    		if(time == 0) {
    			time = 1;//time=1是为了跳的时候有个缓冲
    			location.href="http://localhost:8080/new/NewServlet?jsp=newsindex";
    		}
    		//原生js赋值
    		document.getElementById("time").innerText=time;
    		time = time - 1;
    		}, 1000);
    		};
    	function nowLogin() {
    		location.href="http://localhost:8080/new/NewServlet?jsp=newsindex";
    	}
    </script>
  </head >
  <body onload="returnLogin()">
  		<div align="center">
  			<h3 id="login"></h3>
  			<p>......<span style="color: red" id="choice"></span><span style="color: blue" id="time">5</span>秒后跳转回登录页面</p>
  			<p align="center" style="color: green;cursor: pointer;" onclick="nowLogin()">立刻登录</p>
  		</div>
  </body>
</html>
