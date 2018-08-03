package com.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.TopicDao;
import com.entity.Topic;

public class TopicDaoImp extends BaseDao implements TopicDao{

	@Override
	public int updateTopic(String sql, Object...params) {
		int result = this.executeupdate(sql, params);
		this.closeAll(conn, pstmt, rs);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public List<Topic> findAll() {
		List<Topic> list = new ArrayList<Topic>();
		String sql = "SELECT * FROM topic";
		rs = this.executeQuery(sql);
		try {
			while(rs.next()) {
				Topic topic = new Topic();
				topic.setTid(rs.getInt(1));
				topic.setTname(rs.getString(2));
				list.add(topic);
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
	public List<Topic> findBy(String sql, Object... params) {
		List<Topic> list = new ArrayList<Topic>();
		rs = this.executeQuery(sql, params);
		try {
			while(rs.next()) {
				Topic topic = new Topic();
				topic.setTid(rs.getInt(1));
				topic.setTname(rs.getString(2));
				list.add(topic);
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
	public List<Topic> findByLine(String line, Object param) {
		List<Topic> list = new ArrayList<Topic>();
		String sql = "SELECT * FROM topic where " + line + "=?";
		rs = this.executeQuery(sql, param);
		try {
			while(rs.next()) {
				Topic topic = new Topic();
				topic.setTid(rs.getInt(1));
				topic.setTname(rs.getString(2));
				list.add(topic);
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
