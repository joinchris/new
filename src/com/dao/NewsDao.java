package com.dao;

import java.util.List;

import com.entity.News;

public interface NewsDao {
	/**
	 * 增、伤、改用户
	 * @param user
	 * @return
	 */
	int updateNew(String sql, Object...params);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<News> findAll();
	
	/**
	 * 根据指定条件来差
	 * @param sql
	 * @param params
	 * @return
	 */
	List<News> findBy(String sql,Object...params);
	
	/**
	 * 根据列名、值来查询
	 * @param param
	 * @return
	 */
	List<News> findByLine(String line,Object param, int strip);
	
	/**
	 * 查询份新闻总条数
	 * @return
	 */
	int count(Integer ntid);
}
