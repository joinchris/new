package com.dao;

import java.util.List;

import com.entity.Topic;

public interface TopicDao{
	/**
	 * �����ˡ���
	 * @param user
	 * @return
	 */
	int updateTopic(String sql, Object...params);
	
	/**
	 * ��ѯ����
	 * @return
	 */
	List<Topic> findAll();
	
	/**
	 * ����ָ����������
	 * @param sql
	 * @param params
	 * @return
	 */
	List<Topic> findBy(String sql,Object...params);
	
	/**
	 * ����������ֵ����ѯ
	 * @param param
	 * @return
	 */
	List<Topic> findByLine(String line,Object param);
	
}
