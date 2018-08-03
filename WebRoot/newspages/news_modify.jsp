<%@page import="com.entity.News"%>
<%@page import="com.service.NewsService"%>
<%@page import="com.service.imp.NewsServiceImp"%>
<%@page import="com.entity.Topic"%>
<%@page import="com.service.imp.TopicServiceImp"%>
<%@page import="com.service.TopicService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<title>新闻中国</title>
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
	    <h1 id="opt_type"> 修改新闻： </h1>
		    <form action="http://localhost:8080/new/NewServlet?choice=newModify&jsp=newcontrol" enctype="multipart/form-data" method="post">
		      <p>
		        <label> 主题 </label>
		        <select name="ntid">
		        <c:forEach items="${listTopic}" var="item">
		        		<option value="${item.tid}" <c:if test="${item.tid == news.ntid}" > selected="selected" </c:if>>${item.tname}</option>
		        </c:forEach>
		        </select>
		        <input type="hidden" name="nid" value="${news.nid}" />
		      </p>
		      <p>
		        <label> 标题 </label>
		        <input name="ntitle" type="text" class="opt_input" value="${news.ntitle}"/>
		      </p>
		      <p>
		        <label> 作者 </label>
		        <input name="nauthor" type="text" class="opt_input" value="${news.nauthor}"/>
		      </p>
		      <p>
		        <label> 摘要 </label>
		        <textarea name="nsummary" cols="40" rows="3">${news.nsummary}</textarea>
		      </p>
		      <p>
		        <label> 内容 </label>
		        <textarea name="ncontent" cols="70" rows="5">${news.ncontent}</textarea>
		      </p>
		      <p>
		        <label> 上传图片 </label>
		        <input name="file" type="file" value="${news.npicPath}" class="opt_input"/>
		      </p>
		      <input type="submit" value="提交" class="opt_sub" />
		      <input type="reset" value="重置" class="opt_sub" />
		    </form>
		  </div>
	  </div>
	  <iframe src="http://localhost:8080/new/newspages/console_element/bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>
  </div>
</body>
</html>	