package com.dao;

import java.util.List;

import com.entity.NewsUsers;

public interface NewsUsersDao {
	
	/**
	 * 增、伤、改
	 * @param user
	 * @return
	 */
	int updateUser(String sql, Object...params);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<NewsUsers> findAll();
	
	/**
	 * 根据指定条件来差
	 * @param sql
	 * @param params
	 * @return
	 */
	List<NewsUsers> findBy(String sql,Object...params);
	
	/**
	 * 根据列名、值来查询
	 * @param param
	 * @return
	 */
	List<NewsUsers> findByLine(String line,Object param);
	
}
