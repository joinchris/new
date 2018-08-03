package com.qy.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.NewsUsers;
import com.qy.Qy;
import com.service.NewsUsersService;
import com.service.imp.NewsUsersServiceImp;

public class LoginQy implements Qy{
	@Override
	public void qyDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//如果是登录进入到if选择，根据choice判断进入到哪一个页面
		//登录,退出
  		HttpSession session = request.getSession();
  		PrintWriter out = response.getWriter();
		NewsUsersService  newsUsersService = new NewsUsersServiceImp();
  		request.setCharacterEncoding("UTF-8");
  		//获取判读单页面类型的属性,然后将choice传入下一个界面进行跳转
  		String choice = request.getParameter("choice");
  		if(choice.equals("mainexit")) {
  			session.invalidate();
  			response.sendRedirect("NewServlet?jsp=newsindex");
  			}else if(choice.equals("readexit")) {
  				session.invalidate();
  	  			response.sendRedirect("NewServlet?jsp=newsread");
  			}
  		String uname = request.getParameter("uname");
  		String password = request.getParameter("password");
  		NewsUsers user = newsUsersService.login(uname, password);
  		if(user == null) {
  			//登录之后也要做查询，或者不登录进入页面也要做查询
  			if(choice.equals("main")) {
  				out.print("<script type='text/javascript'>alert('登录失败');location.href='NewServlet?jsp=newsindex';</script>");
  			}else if(choice.equals("read")) {
  				out.print("<script type='text/javascript'>alert('登录失败');location.href='NewServlet?jsp=newsread';</script>");
  			}
  		} else {
  		//如果登录成功，就保存session
  		//给session赋值为choice
  			request.getSession().setAttribute("user", uname);
  	  		session.setMaxInactiveInterval(3000);
  			if(choice.equals("main")) {
  				out.print("<script type='text/javascript'>alert('登录成功');location.href='NewServlet?jsp=newsindex';</script>");
  			}else if(choice.equals("read")) {
  				out.print("<script type='text/javascript'>alert('登录成功');location.href='NewServlet?jsp=newsread';</script>");
  			}
  		}
	}
}
