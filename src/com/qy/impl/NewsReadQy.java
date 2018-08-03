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
		//跳转到newsread.jsp页面
		NewsService newsService = new NewsServiceImp();
		CommentsService commentsService = new CommentsServiceImp();
		//评论的添加删除
		//界面展示,侧边栏
		List<News> listNews1 = newsService.findByLine("ntid",1, 5);
		List<News> listNews2 = newsService.findByLine("ntid",2, 5);
		List<News> listNews3 = newsService.findByLine("ntid",5, 5);
		request.setAttribute("listNews1", listNews1);
		request.setAttribute("listNews2", listNews2);
		request.setAttribute("listNews3", listNews3);
		//展示新闻详情
		//从提交评论处返回的时候以为没有传递nid，所有会报空
    	//nid为空，时，request获取时会报错
    	Integer nid = null;
    	if(request.getParameter("nid") == null) {
    		nid = 52;
    	}else {
    		nid = Integer.parseInt(request.getParameter("nid"));
    	}
    	System.out.println(2222);
    	List<Comments> listComments = commentsService.findByLine("cnid", nid, 10);
    	News news = newsService.findByLine("nid", nid, 1).get(0);
    	request.setAttribute("listComments", listComments);//返回评论
		request.setAttribute("news", news);//返回新闻
		request.getRequestDispatcher("newspages/news_read.jsp").forward(request, response);
	}
}
