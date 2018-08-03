<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
   <script type="text/javascript">
		function check(){
			var tname = document.getElementById("tname");
	
			if(tname.value == ""){
				alert("请输入主题名称！！");
				tname.focus();
				return false;
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
	    <h1 id="opt_type"> 添加主题：</h1>
	    <form action="http://localhost:8080/new/NewServlet"  method="post"  onsubmit="return check()" >
	      <p>
	        <label> 主题名称 </label>
	        <input name="tname" type="text" class="opt_input" />
	      </p>
	      <input name="choice" type="hidden" value="topicAdd">
	      <input name="jsp" type="hidden" value="topiccontrol">
	      <input name="action" type="hidden" value="addtopic">
	      <input type="submit" value="提交" class="opt_sub" />
	      <input type="reset" value="重置" class="opt_sub" />
	    </form>
	  </div>
	  <iframe src="http://localhost:8080/new/newspages/console_element/bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>
  </div>
</body>
</html>		