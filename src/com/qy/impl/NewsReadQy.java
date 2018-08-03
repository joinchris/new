package com.qy.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Comments;
import com.entity.News;
import com.qy.Qy;
import com.service.CommentsService;
import com.service.NewsService;
import com.service.imp.CommentsServiceImp;
import com.service.imp.NewsServiceImp;

public class NewsReadQy implements Qy{
	@Override
	public void qyDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ת��newsread.jspҳ��
		NewsService newsService = new NewsServiceImp();
		CommentsService commentsService = new CommentsServiceImp();
		//���۵����ɾ��
		//����չʾ,�����
		List<News> listNews1 = newsService.findByLine("ntid",1, 5);
		List<News> listNews2 = newsService.findByLine("ntid",2, 5);
		List<News> listNews3 = newsService.findByLine("ntid",5, 5);
		request.setAttribute("listNews1", listNews1);
		request.setAttribute("listNews2", listNews2);
		request.setAttribute("listNews3", listNews3);
		//չʾ��������
		//���ύ���۴����ص�ʱ����Ϊû�д���nid�����лᱨ��
    	//nidΪ�գ�ʱ��request��ȡʱ�ᱨ��
    	Integer nid = null;
    	if(request.getParameter("nid") == null) {
    		nid = 52;
    	}else {
    		nid = Integer.parseInt(request.getParameter("nid"));
    	}
    	System.out.println(2222);
    	List<Comments> listComments = commentsService.findByLine("cnid", nid, 10);
    	News news = newsService.findByLine("nid", nid, 1).get(0);
    	request.setAttribute("listComments", listComments);//��������
		request.setAttribute("news", news);//��������
		request.getRequestDispatcher("newspages/news_read.jsp").forward(request, response);
	}
}
