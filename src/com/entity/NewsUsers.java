package com.entity;

public class NewsUsers {
	/*
	 * 用户id
	 */
	private int uid;
	
	/*
	 * 用户名
	 */
	private String uname;
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	/*
	 * 用户名密码
	 */
	private String upwd;
}
