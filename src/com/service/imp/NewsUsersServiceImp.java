package com.service.imp;

import java.util.List;

import com.dao.NewsUsersDao;
import com.dao.imp.NewsUsersDaoImp;
import com.entity.NewsUsers;
import com.service.NewsUsersService;

public class NewsUsersServiceImp implements NewsUsersService{
	NewsUsersDao newsUsersDao = new NewsUsersDaoImp();

	@Override
	public int addUser(NewsUsers newsUser) {
		String sql = "INSERT INTO news_users(uname,upwd) VALUES(?,?)";
		int result = newsUsersDao.updateUser(sql, newsUser.getUname(),newsUser.getUpwd());
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int delUser(int uid) {
		String sql = "DELETE FROM news_users WHERE uid=?";
		int result = newsUsersDao.updateUser(sql, uid);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int updateUser(NewsUsers newsUser) {
		String sql = "UPDATE news_users SET uname=?,upwd=? where ntid=?";
		int result = newsUsersDao.updateUser(sql, newsUser.getUname(),newsUser.getUpwd(),newsUser.getUid());
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public List<NewsUsers> findAll() {
		 List<NewsUsers> list = newsUsersDao.findAll();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public NewsUsers findById(int uid) {
		List<NewsUsers> list = newsUsersDao.findByLine("uid", uid);
		if(list.size() == 0) {
			return null;
		}else {
			return list.get(0);
		}
		// TODO Auto-generated method stub
	}

	@Override
	public NewsUsers login(String uname,String password) {
		String sql = "SELECT * FROM news_users WHERE uname=? AND upwd=?";
		List<NewsUsers> list = newsUsersDao.findBy(sql, uname, password);
		if(list.size() == 0) {
			return null;
		}else {
			return list.get(0);
		}
	}

}
