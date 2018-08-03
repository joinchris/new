package com.qy.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Topic;
import com.qy.Qy;
import com.service.TopicService;
import com.service.imp.TopicServiceImp;

public class TopicModifyQy implements Qy{
	@Override
	public void qyDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TopicService topicService = new TopicServiceImp();
		String tname = request.getParameter("tname");
      	Topic topic = topicService.findByLine("tname", tname);
      	request.setAttribute("topic", topic);
      	request.getRequestDispatcher("newspages/topic_modify.jsp").forward(request, response);
	}
}
