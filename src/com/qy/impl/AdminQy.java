package com.qy.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.News;
import com.newstool.PageLimit;
import com.qy.Qy;
import com.service.NewsService;
import com.service.imp.NewsServiceImp;

public class AdminQy implements Qy {
	@Override
	public void qyDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ת��admin.jspҳ��
		PageLimit pageLimit = new PageLimit();
		response.setContentType("text/html;charset=UTF-8");
		//����չʾ,��ҳչʾ������������������ǰҳ��ÿҳ��ʾ��
		NewsService newsService = new NewsServiceImp();
		int totalCount = newsService.count(null);
		pageLimit.setTotalCount(totalCount);
		Integer currePageNo = 1;
		int totalPageCount = pageLimit.getTotalPageCount();
		if(request.getParameter("pageIndex") != null) {
			currePageNo = Integer.parseInt(request.getParameter("pageIndex"));
		}
		if(currePageNo < 1) {
			currePageNo = 1;
		}else if(currePageNo > totalPageCount) {
			currePageNo = totalPageCount;
			}
		pageLimit.setCurrePageNo(currePageNo);
		List<News> listNews = newsService.findPage(null, currePageNo, pageLimit.getPageSize());
      	pageLimit.setNewsList(listNews);
		request.setAttribute("pageLimit", pageLimit);
      	request.getRequestDispatcher("newspages/admin.jsp").forward(request, response);
	}
}
