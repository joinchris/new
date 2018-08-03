package com.service;

import java.util.List;

import com.entity.Comments;

public interface CommentsService {
	/**
	 * ����������Ϣ
	 * @param newsUser
	 * @return
	 */
	int addComment(Comments comment);
	
	/**
	 * ɾ��������Ϣ
	 * @param newsUser
	 * @return
	 */
	int delComment(int cid);
	
	/**
	 * �޸�������Ϣ
	 * @param newsUsers
	 * @return
	 */
	int updateComment(Comments comment);
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	List<Comments> findAll();
	
	/**
	 * ����������ѯ������Ϣ
	 * @param uid
	 * @return
	 */
	List<Comments> findByLine(String line, Object param , int strip);
	
}
