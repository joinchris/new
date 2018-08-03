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
		//跳转到newsindex.jsp页面
		//侧边栏
		NewsService newsService = new NewsServiceImp();
		List<News> listNews1 = newsService.findByLine("ntid",1, 5);
		List<News> listNews2 = newsService.findByLine("ntid",2, 5);
		List<News> listNews3 = newsService.findByLine("ntid",5, 5);
		List<News> listImg = newsService.findImg();
		request.setAttribute("listNews1", listNews1);
		request.setAttribute("listNews2", listNews2);
		request.setAttribute("listNews3", listNews3);
		request.setAttribute("listImg", listImg);
		//主题列表显示
		TopicService topicService = new TopicServiceImp();
  		List<Topic> listTopic = topicService.findAll();
  		request.setAttribute("listTopic", listTopic);
  		//分页显示
  		//初始化当前页，和总页数，根据news总数
		Integer ntid = null;
  		if(request.getParameter("ntid") != null) {
  			if(!request.getParameter("ntid").equals("null") ) {
  				if(!request.getParameter("ntid").equals("")) {
  					ntid = Integer.parseInt(request.getParameter("ntid"));
  				}
  			}
  		}
  		int count = newsService.count(ntid);
  		//创建页面对象
  		PageLimit pageLimit = new PageLimit();
  		pageLimit.setTotalCount(count);
  		Integer totalPageCount = pageLimit.getTotalPageCount();
  		//获取传过来的主题id，通过主题id查询信息并展示
  		//获取当前页
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
