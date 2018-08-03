package com.qy.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Topic;
import com.qy.Qy;
import com.service.TopicService;
import com.service.imp.TopicServiceImp;

public class NewsAddQy implements Qy{
	@Override
	public void qyDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ìø×ªµ½newsadd.jspÒ³Ãæ
		TopicService topicService = new TopicServiceImp();
		List<Topic> listTopic = topicService.findAll();
		request.setAttribute("listTopic", listTopic);
		request.getRequestDispatcher("newspages/news_add.jsp").forward(request, response);
	}
}
