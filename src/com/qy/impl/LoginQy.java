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
		//����ǵ�¼���뵽ifѡ�񣬸���choice�жϽ��뵽��һ��ҳ��
		//��¼,�˳�
  		HttpSession session = request.getSession();
  		PrintWriter out = response.getWriter();
		NewsUsersService  newsUsersService = new NewsUsersServiceImp();
  		request.setCharacterEncoding("UTF-8");
  		//��ȡ�ж���ҳ�����͵�����,Ȼ��choice������һ�����������ת
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
  			//��¼֮��ҲҪ����ѯ�����߲���¼����ҳ��ҲҪ����ѯ
  			if(choice.equals("main")) {
  				out.print("<script type='text/javascript'>alert('��¼ʧ��');location.href='NewServlet?jsp=newsindex';</script>");
  			}else if(choice.equals("read")) {
  				out.print("<script type='text/javascript'>alert('��¼ʧ��');location.href='NewServlet?jsp=newsread';</script>");
  			}
  		} else {
  		//�����¼�ɹ����ͱ���session
  		//��session��ֵΪchoice
  			request.getSession().setAttribute("user", uname);
  	  		session.setMaxInactiveInterval(3000);
  			if(choice.equals("main")) {
  				out.print("<script type='text/javascript'>alert('��¼�ɹ�');location.href='NewServlet?jsp=newsindex';</script>");
  			}else if(choice.equals("read")) {
  				out.print("<script type='text/javascript'>alert('��¼�ɹ�');location.href='NewServlet?jsp=newsread';</script>");
  			}
  		}
	}
}
