package com.dao;

import java.util.List;

import com.entity.Comments;

public interface CommentsDao {
	/**
	 * �����ˡ���
	 * @param user
	 * @return
	 */
	int updateComment(String sql, Object...params);
	
	/**
	 * ��ѯ����
	 * @return
	 */
	List<Comments> findAll();
	
	/**
	 * �������
	 * @param sql
	 * @param params
	 * @return
	 */
	List<Comments> findBy(String sql,Object...params);
	
	/**
	 * ����������ֵ��ѯ��Ϣ
	 * @param line
	 * @param param
	 * @return
	 */
	List<Comments> findByLine(String line,Object param, int strip);
}
