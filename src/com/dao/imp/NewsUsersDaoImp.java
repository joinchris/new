package com.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.NewsUsersDao;
import com.entity.NewsUsers;

public class NewsUsersDaoImp extends BaseDao implements NewsUsersDao{

	@Override
	public int updateUser(String sql, Object...params) {
		int result = this.executeupdate(sql, params);
		this.closeAll(conn, pstmt, rs);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public List<NewsUsers> findAll() {
		List<NewsUsers> list = new ArrayList<NewsUsers>();
		String sql = "SELECT * FROM newsusers";
		rs = this.executeQuery(sql);
		try {
			while(rs.next()) {
				NewsUsers newsUsers = new NewsUsers();
				newsUsers.setUid(rs.getInt(1));
				newsUsers.setUname(rs.getString(2));
				newsUsers.setUpwd(rs.getString(3));
				list.add(newsUsers);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			this.closeAll(conn, pstmt, rs);
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<NewsUsers> findBy(String sql, Object... params) {
		List<NewsUsers> list = new ArrayList<NewsUsers>();
		rs = this.executeQuery(sql, params);
		try {
			while(rs.next()) {
				NewsUsers newsUsers = new NewsUsers();
				newsUsers.setUid(rs.getInt(1));
				newsUsers.setUname(rs.getString(2));
				newsUsers.setUpwd(rs.getString(3));
				list.add(newsUsers);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			this.closeAll(conn, pstmt, rs);
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<NewsUsers> findByLine(String line, Object param) {
		List<NewsUsers> list = new ArrayList<NewsUsers>();
		String sql = "SELECT * FROM news_Users where " + line + "=" + param;
		rs = this.executeQuery(sql, param);
		try {
			while(rs.next()) {
				NewsUsers newsUsers = new NewsUsers();
				newsUsers.setUid(rs.getInt(1));
				newsUsers.setUname(rs.getString(2));
				newsUsers.setUpwd(rs.getString(3));
				list.add(newsUsers);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		// TODO Auto-generated method stub
		return list;
	}

}
