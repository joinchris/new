package com.dao.imp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.CommentsDao;
import com.entity.Comments;

public class CommentsDaoImp extends BaseDao implements CommentsDao{

	@Override
	public int updateComment(String sql, Object...params) {
		int result = this.executeupdate(sql, params);
		this.closeAll(conn, pstmt, rs);
		return result;
	}

	@Override
	public List<Comments> findAll() {
		List<Comments> list = new ArrayList<Comments>();
		String sql = "SELECT * FROM comments";
		rs = this.executeQuery(sql);
		try {
			while(rs.next()) {
				Comments comments = new Comments();
				comments.setcid(rs.getInt(1));
				comments.setCnid(rs.getInt(2));
				comments.setCcontent(rs.getString(2));
				comments.setCdate(rs.getTimestamp(4));
				comments.setCip(rs.getString(5));
				comments.setCauthor(rs.getString(6));
				list.add(comments);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Comments> findBy(String sql, Object... params) {
		List<Comments> list = new ArrayList<Comments>();
		rs = this.executeQuery(sql, params);
		try {
			while(rs.next()) {
				Comments comments = new Comments();
				comments.setcid(rs.getInt(1));
				comments.setCnid(rs.getInt(2));
				comments.setCcontent(rs.getString(2));
				comments.setCdate(rs.getTimestamp(4));
				comments.setCip(rs.getString(5));
				comments.setCauthor(rs.getString(6));
				list.add(comments);
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
	public List<Comments> findByLine(String line, Object param, int strip) {
		List<Comments> list = new ArrayList<Comments>();
		String sql = null;
		if(strip == 0) {
			sql = "SELECT * FROM comments WHERE " + line + "=? ORDER BY cdate DESC";
			rs = this.executeQuery(sql, param);
		} else {
			sql = "SELECT * FROM comments WHERE " + line + "=? ORDER BY cdate DESC LIMIT ?";
			rs = this.executeQuery(sql, param, strip);
		}
		try {
			while(rs.next()) {
				Comments comments = new Comments();
				comments.setcid(rs.getInt(1));
				comments.setCnid(rs.getInt(2));
				comments.setCcontent(rs.getString(3));
				comments.setCdate(rs.getTimestamp(4));
				comments.setCip(rs.getString(5));
				comments.setCauthor(rs.getString(6));
				list.add(comments);
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
