package com.service;

import java.util.List;

import com.entity.Comments;

public interface CommentsService {
	/**
	 * 增加评论信息
	 * @param newsUser
	 * @return
	 */
	int addComment(Comments comment);
	
	/**
	 * 删除评论信息
	 * @param newsUser
	 * @return
	 */
	int delComment(int cid);
	
	/**
	 * 修改评论信息
	 * @param newsUsers
	 * @return
	 */
	int updateComment(Comments comment);
	
	/**
	 * 查询所有评论
	 * @return
	 */
	List<Comments> findAll();
	
	/**
	 * 根据列名查询评论信息
	 * @param uid
	 * @return
	 */
	List<Comments> findByLine(String line, Object param , int strip);
	
}
