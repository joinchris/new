<%@page import="com.entity.Comments"%>
<%@page import="com.service.CommentsService"%>
<%@page import="com.service.imp.CommentsServiceImp"%>
<%@page import="com.entity.News"%>
<%@page import="com.service.NewsService"%>
<%@page import="com.service.imp.NewsServiceImp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="http://localhost:8080/new/css/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	  		function check(){
	  			var cauthor = document.getElementById("cauthor");
	  			var content = document.getElementById("ccontent");
	  			if(cauthor.value == ""){
	  				alert("用户名不能为空！！");
	  				return false;
	  			}else if(content.value == ""){
	  				alert("评论内容不能为空！！");
	  				return false;
	  			}
	  			return true;
	  		}
	  	</script>
</head>
<body>
<div id="header">
  <div id="top_login">
  		<c:if test="${empty user}">
  		<form action="http://localhost:8080/new/NewServlet" method="post">
	    	<label> 登录名 </label>
	   		<input type="text" id="uname" name="uname" value="" class="login_input" />
	   		<label> 密&#160;&#160;码 </label>
	    	<input type="password" id="upwd" name="password" value="" class="login_input" />
	    	<input type="submit" class="login_sub" name="login" value="登录" onclick="login()"/>
	    	<input type="hidden" name="choice" value="read" />
	    	<input type="hidden" name="jsp" value="login" />
	    	<label id="error"> </label>
	  	    <span name="message"></span>
  		</c:if>
  		
  		<c:if test="${!empty user}">
  			<span>欢迎您&nbsp;<span>${user}</span>，登录成功&nbsp;&nbsp;&nbsp;<a href="http://localhost:8080/new/NewServlet?choice=readexit&jsp=login">退出</a>
  		</c:if>
    <a href="NewServlet?jsp=newsindex" class="login_link">返回首页</a></span> <img src="http://localhost:8080/new/images/friend_logo.gif" alt="Google" id="friend_logo" /> </div>
  	</form>
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
      <c:forEach items="${listNews1}" var="item">
      	<li><a href="NewServlet?nid=${item.nid}&jsp=newsread"><b>${item.ntitle}</b></a></li>
      </c:forEach>
      </ul>
    </div>
    <h1> <img src="http://localhost:8080/new/images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
       <c:forEach items="${listNews2}" var="item">
      	<li><a href="NewServlet?nid=${item.nid}&jsp=newsread"><b>${item.ntitle}</b></a></li>
      </c:forEach>
      </ul>
    </div>
    <h1> <img src="http://localhost:8080/new/images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
      	<c:forEach items="${listNews3}" var="item">
      	<li><a href="NewServlet?nid=${item.nid}&jsp=newsread"><b>${item.ntitle}</b></a></li>
      </c:forEach>
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="http://localhost:8080/new/images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="classlist">
        <table width="80%" align="center">
          <tr width="100%">
            <td colspan="2" align="center">${news.ntitle}</td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
          <tr>
            <td align="center">${news.nmodifyDate}</td>
            <td align="left">${news.nauthor}</td>
          </tr>
          <tr>
            <td colspan="2" align="center"></td>
          </tr>
          <tr>
            <td colspan="2">${news.ncontent}</tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
        </table>
      </ul>
      <ul class="classlist">
        <table width="80%" align="center">
        <c:choose>
        	<c:when test="${listComments.size() == 0}">
        		<td colspan="6"> 暂无评论！ <hr /></td>
        	</c:when>
        	<c:otherwise>
        		<c:forEach items="${listComments}" var="item" varStatus="status">
        		    <tr>
          	   		 <td>用户名:${item.cauthor}&nbsp;&nbsp;<img style="width: 20px;height:20px;vertical-align: middle;" src="${basePath}images/小猪.PNG" />&nbsp;&nbsp;第${status.index + 1}楼</td>
               		 </tr>
               		 <tr><td colspan="6">&nbsp;&nbsp;${item.ccontent}</td>
               		 <td><a style="cursor: pointer;"  href="NewServlet?choice=commentDel&&cid=${item.cid}&jsp=commentcontrol">删除</a></td>
               		 <td colspan="6">&nbsp;&nbsp;${item.cdate}</td>
               		 </tr>
        		</c:forEach>
        	</c:otherwise>
        </c:choose>
        </table><hr />
      </ul>
      <ul class="classlist">
        <form action="http://localhost:8080/new/NewServlet" method="post" onsubmit="return check()">
          <table width="80%" align="center">
            <tr>
              <td> 评 论 </td>
            </tr>
            <tr>
              <td>用户名:&nbsp;<input name="cauthor" id="cauthor" name="cauthor" value="这家伙很懒什么也没留下"/>
                IP：
                <input name="cip" value="127.0.0.1"
											readonly="readonly"/>
              </td>
            </tr>
            <tr>
              <td colspan="2"><textarea name="ccontent" cols="70" rows="10"></textarea>
              </td>
            </tr>
            <td><input name="submit" value="发  表" type="submit"/>
              </td>
          </table>
          <input type="hidden" name="choice" value="commentAdd" />
          <input type="hidden" name="cnid" value="${news.nid}" />
          <input type="hidden" name="jsp" value="commentcontrol" />
        </form>
      </ul>
    </div>
  </div>
</div>
<div id="footer">  
 <iframe src="http://localhost:8080/new//index-elements/index_bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>
</div>
</body>
</html>
