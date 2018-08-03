package com.service;

import java.util.List;

import com.entity.NewsUsers;

public interface NewsUsersService {
	
	/**
	 * 增加用户信息
	 * @param newsUser
	 * @return
	 */
	int addUser(NewsUsers newsUser);
	
	/**
	 * 删除用户信息
	 * @param newsUser
	 * @return
	 */
	int delUser(int uid);
	
	/**
	 * 修改用户信息
	 * @param newsUsers
	 * @return
	 */
	int updateUser(NewsUsers newsUser);
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<NewsUsers> findAll();
	
	/**
	 * 根据id查询新闻信息
	 * @param uid
	 * @return
	 */
	NewsUsers findById(int uid);
	
	/**
	 * 登录
	 * @param uname
	 * @param password
	 * @return
	 */
    NewsUsers login(String uname,String password);
	
}
