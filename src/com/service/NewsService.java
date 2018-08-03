package com.service;

import java.util.List;

import com.entity.News;

public interface NewsService {
	/**
	 * ����������Ϣ
	 * @param newsUser
	 * @return
	 */
	int addnew(News news);
	
	/**
	 * ɾ��������Ϣ
	 * @param newsUser
	 * @return
	 */
	int delNew(int nid);
	
	/**
	 * �޸�������Ϣ
	 * @param newsUsers
	 * @return
	 */
	int updateNew(News news);
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	List<News> findAll();
	
	/**
	 * ������������ʾ������ѯ
	 * @param param
	 * @param strip
	 * @return
	 */
	List<News> findByLine(String line, Object param, int strip);
	
	/**
	 * ����������
	 * @param sql
	 * @return
	 */
	int count(Integer ntid);
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNow
	 * @param pageShow
	 * @param pageTotle
	 * @return
	 */
	List<News> findPage(Integer tid, int currePageNo, int pageSize);
	
	/**
	 * ��ѯ����
	 * @param line
	 * @param param
	 * @return
	 */
	List<News> findImg();
}
