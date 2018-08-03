<%@page import="com.newstool.PageLimit"%>
<%@page import="com.entity.News"%>
<%@page import="com.service.NewsService"%>
<%@page import="com.service.imp.NewsServiceImp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>添加主题--管理后台</title>
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
	    	<c:forEach items="${pageLimit.newsList}" var="item" varStatus="status">
	    		<c:if test="${status.index %5 == 0 && status.index != 0}"><br/></c:if>
	    		<li>${item.ntitle}<span> 作者： ${item.nauthor}                                             
	      	    &#160;&#160;&#160;&#160; <a href='NewServlet?jsp=newsmodify&nid=${item.nid}&jsp=newcontrol'>修改</a> &#160;&#160;&#160;&#160; <a href='NewServlet?choice=newDel&&nid=${item.nid}&jsp=newcontrol'>删除</a> </span> </li>
	    	</c:forEach>
	      <li class='space'></li>
	      <p align="right"><a href="NewServlet?pageIndex=1&jsp=adminjsp">首页</a>&nbsp; 
	      <a href="NewServlet?pageIndex=${pageLimit.currePageNo - 1}&jsp=adminjsp">上一页</a>&nbsp;
	      	当前页数:[${pageLimit.currePageNo}]/[${pageLimit.totalPageCount}&nbsp;
	      <a href="NewServlet?pageIndex=${pageLimit.currePageNo + 1}&jsp=adminjsp">下一页</a>&nbsp;
	      <a href="NewServlet?pageIndex=${pageLimit.totalPageCount}&jsp=adminjsp">末页</a> </p>
	    </ul>
	  </div>	  
	  <iframe src="http://localhost:8080/new/newspages/console_element/bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>
    </div>
</body>
</html>

	