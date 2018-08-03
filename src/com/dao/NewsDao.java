package com.dao;

import java.util.List;

import com.entity.News;

public interface NewsDao {
	/**
	 * �����ˡ����û�
	 * @param user
	 * @return
	 */
	int updateNew(String sql, Object...params);
	
	/**
	 * ��ѯ����
	 * @return
	 */
	List<News> findAll();
	
	/**
	 * ����ָ����������
	 * @param sql
	 * @param params
	 * @return
	 */
	List<News> findBy(String sql,Object...params);
	
	/**
	 * ����������ֵ����ѯ
	 * @param param
	 * @return
	 */
	List<News> findByLine(String line,Object param, int strip);
	
	/**
	 * ��ѯ������������
	 * @return
	 */
	int count(Integer ntid);
}
