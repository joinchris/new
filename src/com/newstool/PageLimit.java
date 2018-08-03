package com.newstool;

import java.util.List;

import com.entity.News;

public class PageLimit {
	//分页显示实体类
	private int totalPageCount = 1;//总页数
	private int pageSize = 25;//页面大小，每页显示的记录数
	private int totalCount;//记录总行数
	private int currePageNo = 1;//当前页码
	private List<News> newsList;//每页记录数的集合
	
	public int getTotalPageCount() {
		return totalPageCount;
	}
	
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	//设置页面大小，如果每页的行数大于0 ，那么就赋当前页面的行数
	public void setPageSize(int pageSize) {
		if(pageSize > 0) {
			this.pageSize = pageSize;
		}
	}
	public int getTotalCount() {
		return totalCount;
	}
	
	//记录总数
	public void setTotalCount(int totalCount) {
		if(totalCount > 0) {
			this.totalCount = totalCount;
			//计算总页数,如果总行数对每页显示数量取余等于零，那么页面数量就等于总行数除以每页显示的行数
			totalPageCount = (this.totalCount % pageSize == 0) ? 
			(this.totalCount / pageSize) : (this.totalCount / pageSize + 1);
		}
	}
	
	//获取当前页码：如果总页面数为0, 那么当前页码为0
	public int getCurrePageNo() {
		if(totalPageCount == 0){ 
			return 0;
			}
			return currePageNo;
	}
	
	//给当前页码赋值：当前页面大于0，那么就赋当前页
	public void setCurrePageNo(int currePageNo) {
		if(currePageNo > 0) {
			this.currePageNo = currePageNo;
		}
	}
	
	public List<News> getNewsList() {
		return newsList;
	}
	
	
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
	
}
