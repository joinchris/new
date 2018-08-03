package com.dao;

import java.util.List;

import com.entity.Comments;

public interface CommentsDao {
	/**
	 * 增、伤、改
	 * @param user
	 * @return
	 */
	int updateComment(String sql, Object...params);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<Comments> findAll();
	
	/**
	 * 组合来差
	 * @param sql
	 * @param params
	 * @return
	 */
	List<Comments> findBy(String sql,Object...params);
	
	/**
	 * 根据列名和值查询信息
	 * @param line
	 * @param param
	 * @return
	 */
	List<Comments> findByLine(String line,Object param, int strip);
}
