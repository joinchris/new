package com.newstool;

import java.util.List;

import com.entity.News;

public class PageLimit {
	//��ҳ��ʾʵ����
	private int totalPageCount = 1;//��ҳ��
	private int pageSize = 25;//ҳ���С��ÿҳ��ʾ�ļ�¼��
	private int totalCount;//��¼������
	private int currePageNo = 1;//��ǰҳ��
	private List<News> newsList;//ÿҳ��¼���ļ���
	
	public int getTotalPageCount() {
		return totalPageCount;
	}
	
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	//����ҳ���С�����ÿҳ����������0 ����ô�͸���ǰҳ�������
	public void setPageSize(int pageSize) {
		if(pageSize > 0) {
			this.pageSize = pageSize;
		}
	}
	public int getTotalCount() {
		return totalCount;
	}
	
	//��¼����
	public void setTotalCount(int totalCount) {
		if(totalCount > 0) {
			this.totalCount = totalCount;
			//������ҳ��,�����������ÿҳ��ʾ����ȡ������㣬��ôҳ�������͵�������������ÿҳ��ʾ������
			totalPageCount = (this.totalCount % pageSize == 0) ? 
			(this.totalCount / pageSize) : (this.totalCount / pageSize + 1);
		}
	}
	
	//��ȡ��ǰҳ�룺�����ҳ����Ϊ0, ��ô��ǰҳ��Ϊ0
	public int getCurrePageNo() {
		if(totalPageCount == 0){ 
			return 0;
			}
			return currePageNo;
	}
	
	//����ǰҳ�븳ֵ����ǰҳ�����0����ô�͸���ǰҳ
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
