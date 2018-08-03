package com.qy.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.News;
import com.entity.Topic;
import com.qy.Qy;
import com.service.NewsService;
import com.service.TopicService;
import com.service.imp.NewsServiceImp;
import com.service.imp.TopicServiceImp;

public class NewsModifyQy implements Qy{
	@Override
	public void qyDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ìø×ªµ½newsmodify.jspÒ³Ãæ
		TopicService topicService = new TopicServiceImp();
		List<Topic> listTopic = topicService.findAll();
		request.setAttribute("listTopic", listTopic);
		NewsService newsService = new NewsServiceImp();
		int nid = Integer.parseInt(request.getParameter("nid"));
		News news = newsService.findByLine("nid", nid, 1).get(0);
		request.setAttribute("news", news);
		request.getRequestDispatcher("newspages/news_modify.jsp").forward(request, response);
	}
}
