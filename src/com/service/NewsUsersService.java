package com.service;

import java.util.List;

import com.entity.NewsUsers;

public interface NewsUsersService {
	
	/**
	 * �����û���Ϣ
	 * @param newsUser
	 * @return
	 */
	int addUser(NewsUsers newsUser);
	
	/**
	 * ɾ���û���Ϣ
	 * @param newsUser
	 * @return
	 */
	int delUser(int uid);
	
	/**
	 * �޸��û���Ϣ
	 * @param newsUsers
	 * @return
	 */
	int updateUser(NewsUsers newsUser);
	
	/**
	 * ��ѯ�����û���Ϣ
	 * @return
	 */
	List<NewsUsers> findAll();
	
	/**
	 * ����id��ѯ������Ϣ
	 * @param uid
	 * @return
	 */
	NewsUsers findById(int uid);
	
	/**
	 * ��¼
	 * @param uname
	 * @param password
	 * @return
	 */
    NewsUsers login(String uname,String password);
	
}
