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
    <%
    	String url = null; 
    	//因为程序还是从上到下执行，所以不管先执行jsp>java>js>html 总归都要按照从上到下的执行顺序
    	String choice = (String)session.getAttribute("choice");
  			if(choice.equals("main")) {
  				url="http://localhost:8080/new/index.jsp";
  			} else if(choice.equals("read")) { 
  				url="http://localhost:8080/new/newspages/news_read.jsp";
  			}
    %>
	<script type="text/javascript">
	//创建计时器
    function returnLogin() {
   			var time = 4;
    		setInterval(function() {
    		if(time == 0) {
    			time = 1;//time=1是为了跳的时候有个缓冲
    			location.href="<%=url%>";
    		}
    		//原生js赋值
    		document.getElementById("time").innerText=time;
    		time = time - 1;
    		}, 1000);
    		};
    	function nowLogin() {
    		location.href="<%=url%>";
    	}
    </script>
  </head >
  <body onload="returnLogin()">
  		<div align="center">
  			<h3 id="login"></h3>
  			<p>......<span style="color: red" id="choice"></span><span style="color: blue" id="time">5</span>秒后跳转回登录页面</p>
  		</div>
  		<%
  			//可以通过获取session的值来判断跳转至哪一个页面（成功提示成功或者失败提示失败）
  			request.setCharacterEncoding("UTF-8");
  			//session为Object对象，所以强转
  			Object sessionVal = session.getAttribute("user");
  			if(sessionVal == null) {
  				%>	
  					<script type="text/javascript">
  						document.getElementById("choice").innerText="登录失败";
  					</script>
  				<%
  			} else {
  				%>	
  					<p align="center" style="color: green;cursor: pointer;" onclick="nowLogin()">立刻登录</p>
  					<script type="text/javascript">
  						document.getElementById("choice").innerText="登录成功";
  					</script>
  				<%
  			}
  		 %>
  </body>
</html>
