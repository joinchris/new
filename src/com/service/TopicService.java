package com.service;

import java.util.List;

import com.entity.Topic;

public interface TopicService {
	/**
	 * ����������Ϣ
	 * @param newsUser
	 * @return
	 */
	int addTopic(Topic topic);
	
	/**
	 * ɾ��������Ϣ
	 * @param newsUser
	 * @return
	 */
	int delTopic(int tid);
	
	/**
	 * �޸�������Ϣ
	 * @param newsUsers
	 * @return
	 */
	int updateTopic(Topic topic);
	
	/**
	 * ��ѯ����������Ϣ
	 * @return
	 */
	List<Topic> findAll();
	
	/**
	 * ������������
	 * @param line
	 * @param param
	 * @return
	 */
	Topic findByLine(String line, Object param);
}
