package com.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.NewsDao;
import com.entity.News;

public class NewsDaoImp extends BaseDao implements NewsDao{

	@Override
	public int updateNew(String sql, Object...params) {
		int result = this.executeupdate(sql, params);
		this.closeAll(conn, pstmt, rs);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public List<News> findAll() {
		List<News> list = new ArrayList<News>();
		String sql = "SELECT * FROM news";
		rs = this.executeQuery(sql);
		try {
			while(rs.next()) {
				News news = new News();
				news.setNid(rs.getInt(1));
				news.setNtid(rs.getInt(2));
				news.setNtitle(rs.getString(3));
				news.setNauthor(rs.getString(4));
				news.setNcreateDate(rs.getTimestamp(5));
				news.setNpicPath(rs.getString(6));
				news.setNcontent(rs.getString(7));
				news.setNmodifyDate(rs.getTimestamp(8));
				news.setNsummary(rs.getString(9));
				list.add(news);
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

	@Override
	public List<News> findBy(String sql, Object... params) {
		List<News> list = new ArrayList<News>();
		rs = this.executeQuery(sql, params);
		try {
			while(rs.next()) {
				News news = new News();
				news.setNid(rs.getInt(1));
				news.setNtid(rs.getInt(2));
				news.setNtitle(rs.getString(3));
				news.setNauthor(rs.getString(4));
				news.setNcreateDate(rs.getTimestamp(5));
				news.setNpicPath(rs.getString(6));
				news.setNcontent(rs.getString(7));
				news.setNmodifyDate(rs.getTimestamp(8));
				news.setNsummary(rs.getString(9));
				list.add(news);
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

	@Override
	public List<News> findByLine(String line, Object param, int strip) {
		List<News> list = new ArrayList<News>();
		StringBuffer sql = new StringBuffer("SELECT * FROM news WHERE 1=1 ");
		if(line != null) {
			sql.append("&&" + line).append("=? ORDER BY nmodifyDate DESC limit ?");
			rs = this.executeQuery(sql.toString(), param, strip);
		}else {
			sql.append("ORDER BY nmodifyDate DESC limit ?");
			rs = this.executeQuery(sql.toString(), strip);
		} 
		try {
			while(rs.next()) {
				News news = new News();
				news.setNid(rs.getInt(1));
				news.setNtid(rs.getInt(2));
				news.setNtitle(rs.getString(3));
				news.setNauthor(rs.getString(4));
				news.setNcreateDate(rs.getTimestamp(5));
				news.setNpicPath(rs.getString(6));
				news.setNcontent(rs.getString(7));
				news.setNmodifyDate(rs.getTimestamp(8));
				news.setNsummary(rs.getString(9));
				list.add(news);
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

	@Override
	public int count(Integer ntid) {
		String sql = "SELECT count(1) FROM news ";
		if(ntid != null) {
			sql = "SELECT count(1) FROM news where ntid=?";
			rs = this.executeQuery(sql, ntid);
		}else{
			rs = this.executeQuery(sql);
		}
		int count = -1;
		try {
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		// TODO Auto-generated method stub
		return count;
	}
}
