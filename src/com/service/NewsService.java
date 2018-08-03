package com.service;

import java.util.List;

import com.entity.News;

public interface NewsService {
	/**
	 * 增加新闻信息
	 * @param newsUser
	 * @return
	 */
	int addnew(News news);
	
	/**
	 * 删除新闻信息
	 * @param newsUser
	 * @return
	 */
	int delNew(int nid);
	
	/**
	 * 修改新闻信息
	 * @param newsUsers
	 * @return
	 */
	int updateNew(News news);
	
	/**
	 * 查询所有新闻
	 * @return
	 */
	List<News> findAll();
	
	/**
	 * 根据列名，显示行数查询
	 * @param param
	 * @param strip
	 * @return
	 */
	List<News> findByLine(String line, Object param, int strip);
	
	/**
	 * 传新闻条数
	 * @param sql
	 * @return
	 */
	int count(Integer ntid);
	
	/**
	 * 分页查询
	 * @param pageNow
	 * @param pageShow
	 * @param pageTotle
	 * @return
	 */
	List<News> findPage(Integer tid, int currePageNo, int pageSize);
	
	/**
	 * 查询单列
	 * @param line
	 * @param param
	 * @return
	 */
	List<News> findImg();
}
