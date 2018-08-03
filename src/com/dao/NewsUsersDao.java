package com.dao;

import java.util.List;

import com.entity.NewsUsers;

public interface NewsUsersDao {
	
	/**
	 * �����ˡ���
	 * @param user
	 * @return
	 */
	int updateUser(String sql, Object...params);
	
	/**
	 * ��ѯ����
	 * @return
	 */
	List<NewsUsers> findAll();
	
	/**
	 * ����ָ����������
	 * @param sql
	 * @param params
	 * @return
	 */
	List<NewsUsers> findBy(String sql,Object...params);
	
	/**
	 * ����������ֵ����ѯ
	 * @param param
	 * @return
	 */
	List<NewsUsers> findByLine(String line,Object param);
	
}
