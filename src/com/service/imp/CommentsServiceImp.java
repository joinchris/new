package com.service.imp;

import java.util.List;

import com.dao.CommentsDao;
import com.dao.imp.CommentsDaoImp;
import com.entity.Comments;
import com.service.CommentsService;

public class CommentsServiceImp implements CommentsService{
	CommentsDao commentsDao = new CommentsDaoImp();

	@Override
	public int addComment(Comments comment) {
		String sql = "INSERT INTO comments(cnid,ccontent,cdate,cip,cauthor) VALUES(?,?,?,?,?);";
		int result = commentsDao.updateComment(sql, comment.getCnid(), comment.getCcontent(), comment.getCdate(), comment.getCip(), comment.getCauthor());
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int delComment(int cid) {
		String sql = "DELETE FROM comments WHERE cid=?";
		int result = commentsDao.updateComment(sql, cid);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int updateComment(Comments comment) {
		String sql = "UPDATE comments SET cnid=?,ccontent=?,cdate=?,cip=?,cauthor=? WHERE cid=?";
		int result = commentsDao.updateComment(sql, comment.getCnid(), comment.getCcontent(), comment.getCdate(), comment.getCip(), comment.getCauthor(),comment.getcid(),comment.getcid());
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public List<Comments> findAll() {
		List<Comments> list = commentsDao.findAll();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Comments> findByLine(String line, Object param , int strip) {
		List<Comments> list = commentsDao.findByLine(line, param , strip);
		// TODO Auto-generated method stub
		return list;
	}
}
