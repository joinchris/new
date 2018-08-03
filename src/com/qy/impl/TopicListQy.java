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

public class TopicListQy implements Qy{
	@Override
	public void qyDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ìø×ªµ½topic_list.jspÒ³Ãæ
		TopicService topicService = new TopicServiceImp();
		List<Topic> listTopic = topicService.findAll();
		request.setAttribute("listTopic", listTopic);
		request.getRequestDispatcher("newspages/topic_list.jsp").forward(request, response);
	}
}
