package com.service;

import java.util.List;

import com.entity.Topic;

public interface TopicService {
	/**
	 * 增加主题信息
	 * @param newsUser
	 * @return
	 */
	int addTopic(Topic topic);
	
	/**
	 * 删除主题信息
	 * @param newsUser
	 * @return
	 */
	int delTopic(int tid);
	
	/**
	 * 修改主题信息
	 * @param newsUsers
	 * @return
	 */
	int updateTopic(Topic topic);
	
	/**
	 * 查询所有主题信息
	 * @return
	 */
	List<Topic> findAll();
	
	/**
	 * 根据列名查找
	 * @param line
	 * @param param
	 * @return
	 */
	Topic findByLine(String line, Object param);
}
