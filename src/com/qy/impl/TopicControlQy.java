package com.qy.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Topic;
import com.qy.Qy;
import com.service.TopicService;
import com.service.imp.TopicServiceImp;

public class TopicControlQy implements Qy{
	@Override
	public void qyDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//��ת��topiccontrolҳ��
		TopicService topicService = new TopicServiceImp();
		PrintWriter out = response.getWriter();
		String choice = request.getParameter("choice");
		if(choice.equals("topicAdd")) {
			String tname = request.getParameter("tname");
    		Topic topic = new Topic();
    		topic.setTname(tname);
    		int result = topicService.addTopic(topic);
    		if(result == 0) {
    			out.println("<script type='text/javascript'>alert('���ʧ��');location.href='NewServlet?jsp=topiclist';</script>");
    		} else {
    			out.println("<script type='text/javascript'>alert('��ӳɹ�');location.href='NewServlet?jsp=topiclist';</script>");
    		}
		}else if(choice.equals("topicDel")) {
			String tid = request.getParameter("tid");
    		int result = topicService.delTopic(Integer.parseInt(tid));
			if(result == 0) {
    			out.println("<script type='text/javascript'>alert('ɾ��ʧ��');location.href='NewServlet?jsp=topiclist';</script>");
    		} else {
    			out.println("<script type='text/javascript'>alert('ɾ���ɹ�');location.href='NewServlet?jsp=topiclist';</script>");
    		}
		}else if(choice.equals("topicModify")) {
			String tname = request.getParameter("tname");
    		//�����������ֵ
    		Integer tid = Integer.parseInt(request.getParameter("tid"));
    		Topic newTopic = new Topic();
    		newTopic.setTid(tid);
    		newTopic.setTname(tname);
    		//�ٰ���ϳɵ���Ϣ��ӵ����ݿ�
    		int result = topicService.updateTopic(newTopic);
			if(result == 0) {
    			out.println("<script type='text/javascript'>alert('�޸�ʧ��');location.href='NewServlet?jsp=topiclist';</script>");
    		} else {
    			out.println("<script type='text/javascript'>alert('�޸ĳɹ�');location.href='NewServlet?jsp=topiclist';</script>");
    		}
		}
	}
}
