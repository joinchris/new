<%@page import="com.entity.Topic"%>
<%@page import="com.service.TopicService"%>
<%@page import="com.service.imp.TopicServiceImp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
   <title>添加新闻--管理后台</title>    
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
    <h1 id="opt_type"> 添加新闻： </h1>
    <form action="http://localhost:8080/new/NewServlet?choice=newAdd&jsp=newcontrol" enctype="multipart/form-data" method="post">
      <p>
        <label> 主题 </label>
        <select name="ntid">
          <option value="1">选择</option>
          <c:forEach items="${listTopic}" var="item">
          		<option value="${item.tid}">${item.tname}</option>
          </c:forEach>
        </select>
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" type="text" class="opt_input" />
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" type="text" class="opt_input" />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="nsummary" cols="40" rows="3"></textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea name="ncontent" cols="70" rows="10"></textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input name="file" type="file" class="opt_input" />
      </p>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>  
  <iframe src="http://localhost:8080/new/newspages/console_element/bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>
  </div>
</body>
</html>
  