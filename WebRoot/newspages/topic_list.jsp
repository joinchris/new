<%@page import="com.entity.Topic"%>
<%@page import="com.service.imp.TopicServiceImp"%>
<%@page import="com.service.TopicService"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<title>编辑主题--管理后台</title>
   <script type="text/javascript">
		function check(){
			var tname = document.getElementById("tname");
	
			if(tname.value == ""){
				alert("请输入主题名称！！");
				tname.focus();
				return false;m
			}		
			return true;
		}
	</script>
    <link href="http://localhost:8080/new/css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
  <div id="main">
      <div>
	    <iframe src="http://localhost:8080/new/newspages/console_element/top.html" scrolling="no" frameborder="0" width="947px" height="180px"></iframe>
	  </div> 
      <div id="opt_list">
      	<iframe src="http://localhost:8080/new/newspages/console_element/left.html" scrolling="no" frameborder="0" width="130px"></iframe>
      </div> 
	  <div id="opt_area">
	    <ul class="classlist"> 
	    	<c:forEach items="${listTopic}" var="item">
	    		<li>${item.tname}
			    &nbsp;&nbsp;&nbsp;&nbsp; <a href="http://localhost:8080/new/NewServlet?tname=${item.tname}&jsp=topicmodify">修改</a> 
			    &nbsp;&nbsp;&nbsp;&nbsp; <a href="http://localhost:8080/new/NewServlet?choice=topicDel&&tid=${item.tid}&jsp=topiccontrol" value="">删除</a>
				</li>
	    	</c:forEach>
			</ul>
	  </div>
	  <iframe src="http://localhost:8080/new/newspages/console_element/bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>
  </div>
</body>
</html>	