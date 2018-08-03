package com.qy.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.News;
import com.entity.Topic;
import com.newstool.PageLimit;
import com.qy.Qy;
import com.service.NewsService;
import com.service.TopicService;
import com.service.imp.NewsServiceImp;
import com.service.imp.TopicServiceImp;

public class NewsIndexQy implements Qy{
	@Override
	public void qyDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ת��newsindex.jspҳ��
		//�����
		NewsService newsService = new NewsServiceImp();
		List<News> listNews1 = newsService.findByLine("ntid",1, 5);
		List<News> listNews2 = newsService.findByLine("ntid",2, 5);
		List<News> listNews3 = newsService.findByLine("ntid",5, 5);
		List<News> listImg = newsService.findImg();
		request.setAttribute("listNews1", listNews1);
		request.setAttribute("listNews2", listNews2);
		request.setAttribute("listNews3", listNews3);
		request.setAttribute("listImg", listImg);
		//�����б���ʾ
		TopicService topicService = new TopicServiceImp();
  		List<Topic> listTopic = topicService.findAll();
  		request.setAttribute("listTopic", listTopic);
  		//��ҳ��ʾ
  		//��ʼ����ǰҳ������ҳ��������news����
		Integer ntid = null;
  		if(request.getParameter("ntid") != null) {
  			if(!request.getParameter("ntid").equals("null") ) {
  				if(!request.getParameter("ntid").equals("")) {
  					ntid = Integer.parseInt(request.getParameter("ntid"));
  				}
  			}
  		}
  		int count = newsService.count(ntid);
  		//����ҳ�����
  		PageLimit pageLimit = new PageLimit();
  		pageLimit.setTotalCount(count);
  		Integer totalPageCount = pageLimit.getTotalPageCount();
  		//��ȡ������������id��ͨ������id��ѯ��Ϣ��չʾ
  		//��ȡ��ǰҳ
  		int pageIndex = 1;
  		if(request.getParameter("pageIndex") != null) {
  		pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
  		}
  		if(pageIndex < 1) {
  		pageIndex = 1;
  		}else if(pageIndex > pageLimit.getTotalPageCount()) {
  		pageIndex = pageLimit.getTotalPageCount();
  		}
  		List<News> listPage = newsService.findPage(ntid, pageIndex, pageLimit.getPageSize());
  		request.setAttribute("listPage", listPage);
  		request.setAttribute("totalPageCount", totalPageCount);
  		request.setAttribute("pageIndex", pageIndex);
  		request.setAttribute("ntid", ntid);
  		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
