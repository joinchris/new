<%@page import="com.newstool.PageLimit"%>
<%@page import="com.entity.News"%>
<%@page import="com.service.imp.NewsServiceImp"%>
<%@page import="com.service.NewsService"%>
<%@page import="org.apache.taglibs.standard.tag.el.core.ForEachTag"%>
<%@page import="com.entity.Topic"%>
<%@page import="com.service.imp.TopicServiceImp"%>
<%@page import="com.service.TopicService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="http://localhost:8080/new/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div id="top_login">
  		<c:if test="${empty sessionScope.user}" var="islogin" scope="page" >
  		<form action="NewServlet?choice=main&jsp=login" method="post">
	    	<label> 登录名 </label>
	   		<input type="text" id="uname" name="uname" value="" class="login_input" />
	   		<label> 密&#160;&#160;码 </label>
	    	<input type="password" id="upwd" name="password" value="" class="login_input" />
	    	<input type="submit" class="login_sub" name="login" value="登录" onclick="login()"/>
	    	<span name="message"></span>
    	</form>
  		</c:if>
  		
  		<c:if test="${!islogin}" > 
  		    <p>欢迎您&nbsp;<span>${sessionScope.user}</span>，登录成功 <a href="NewServlet?choice=mainexit&jsp=login">退出</a>&nbsp;&nbsp;<a href="NewServlet?jsp=adminjsp">管理系统</a></p>
  		</c:if>
    <label id="error"> </label>
    <img src="http://localhost:8080/new/images/friend_logo.gif" alt="Google" id="friend_logo" /> </div>
  <div id="nav">
    <div id="logo"> <img src="http://localhost:8080/new/images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="http://localhost:8080/new/images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">
  <div class="sidebar">
    <h1> <img src="http://localhost:8080/new/images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
      	<c:forEach items="${listNews1}" var="item" varStatus="status">
      		<li><a href="NewServlet?nid=${item.nid}&jsp=newsread"><b>${item.ntitle}</b></a></li>
      	</c:forEach>
      </ul>
    </div>
    <h1> <img src="http://localhost:8080/new/images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
      	<c:forEach items="${listNews2}" var="item" varStatus="status">
      		<li><a href="NewServlet?nid=${item.nid}&jsp=newsread"><b>${item.ntitle}</b></a></li>
      	</c:forEach>
      </ul>
    </div>
    <h1> <img src="http://localhost:8080/new/images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
      	<c:forEach items="${listNews3}" var="item" varStatus="status">
      		<li><a href="NewServlet?nid=${item.nid}&jsp=newsread"><b>${item.ntitle}</b></a></li>
      	</c:forEach>
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="http://localhost:8080/new/images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
      <li id='class_month'> 
      	<c:forEach items="${listTopic}" var="item" varStatus="status">
      		<c:if test="${status.index == 11}"><br/></c:if>
      		<a href="NewServlet?ntid=${item.tid}&jsp=newsindex"><b>${item.tname}</b></a>
      	</c:forEach>
      </li>
      </ul>
      <ul class="classlist">
      	<c:forEach items="${listPage}" var="item" varStatus="status" >
      		<c:if test="${status.index %5 == 0}" ><br/></c:if>
      		<li><a href="NewServlet?nid=${item.nid}&jsp=newsread">${item.ntitle}</a><span>${item.nmodifyDate }</span></li>
      	</c:forEach>
        <p align="right"><a href="NewServlet?pageIndex=1&ntid=${ntid}&jsp=newsindex">首页</a>&nbsp; 
        <a href="NewServlet?pageIndex=${pageIndex-1}&ntid=${ntid}&jsp=newsindex">上一页&nbsp;</a>
        <span >当前页数:[${pageIndex}]/[${totalPageCount}]</span>>&nbsp; 
        <a href="NewServlet?pageIndex=${pageIndex+1}&ntid=${ntid}&jsp=newsindex">下一页</a> &nbsp;
        <a href="NewServlet?pageIndex=${totalPageCount}&ntid=${ntid}&jsp=newsindex">末页</a></p>
      </ul>
    </div>
    <div class="picnews">
      <ul>
      	<c:forEach items="${listImg}" var="item" >
      		<li> <a href="NewServlet?nid=${item.nid}&jsp=newsread"><img src="${basePath}${item.npicPath}" width="249" alt="" /> </a><a href="NewServlet?nid=${item.nid}&jsp=newsread">${item.ntitle}</a> </li>
      	</c:forEach>
      </ul>
    </div>
  </div>
</div> 
<div id="footer">  
 <iframe src="http://localhost:8080/new/index-elements/index_bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>
</div> 
</body>
</html>
	