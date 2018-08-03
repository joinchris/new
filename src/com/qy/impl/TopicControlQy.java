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
		//跳转到topiccontrol页面
		TopicService topicService = new TopicServiceImp();
		PrintWriter out = response.getWriter();
		String choice = request.getParameter("choice");
		if(choice.equals("topicAdd")) {
			String tname = request.getParameter("tname");
    		Topic topic = new Topic();
    		topic.setTname(tname);
    		int result = topicService.addTopic(topic);
    		if(result == 0) {
    			out.println("<script type='text/javascript'>alert('添加失败');location.href='NewServlet?jsp=topiclist';</script>");
    		} else {
    			out.println("<script type='text/javascript'>alert('添加成功');location.href='NewServlet?jsp=topiclist';</script>");
    		}
		}else if(choice.equals("topicDel")) {
			String tid = request.getParameter("tid");
    		int result = topicService.delTopic(Integer.parseInt(tid));
			if(result == 0) {
    			out.println("<script type='text/javascript'>alert('删除失败');location.href='NewServlet?jsp=topiclist';</script>");
    		} else {
    			out.println("<script type='text/javascript'>alert('删除成功');location.href='NewServlet?jsp=topiclist';</script>");
    		}
		}else if(choice.equals("topicModify")) {
			String tname = request.getParameter("tname");
    		//接收隐藏域的值
    		Integer tid = Integer.parseInt(request.getParameter("tid"));
    		Topic newTopic = new Topic();
    		newTopic.setTid(tid);
    		newTopic.setTname(tname);
    		//再把组合成的信息添加到数据库
    		int result = topicService.updateTopic(newTopic);
			if(result == 0) {
    			out.println("<script type='text/javascript'>alert('修改失败');location.href='NewServlet?jsp=topiclist';</script>");
    		} else {
    			out.println("<script type='text/javascript'>alert('修改成功');location.href='NewServlet?jsp=topiclist';</script>");
    		}
		}
	}
}
