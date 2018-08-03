package com.dao;

import java.util.List;

import com.entity.Topic;

public interface TopicDao{
	/**
	 * 增、伤、改
	 * @param user
	 * @return
	 */
	int updateTopic(String sql, Object...params);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<Topic> findAll();
	
	/**
	 * 根据指定条件来差
	 * @param sql
	 * @param params
	 * @return
	 */
	List<Topic> findBy(String sql,Object...params);
	
	/**
	 * 根据列名、值来查询
	 * @param param
	 * @return
	 */
	List<Topic> findByLine(String line,Object param);
	
}
