package com.service.imp;
import java.util.ArrayList;
import java.util.List;

import com.dao.NewsDao;
import com.dao.imp.NewsDaoImp;
import com.entity.News;
import com.service.NewsService;

public class NewsServiceImp implements NewsService{
	NewsDao newsDao = new NewsDaoImp();

	@Override
	public int addnew(News news) {
		String sql = "INSERT INTO news(ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nmodifyDate,nsummary) VALUES(?,?,?,?,?,?,?,?)";
		int result = newsDao.updateNew(sql, news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNcreateDate(),news.getNpicPath(),news.getNcontent(),news.getNmodifyDate(),news.getNsummary());
		// TODO Auto-generated method stub
		return result;
	}
	
	@Override
	public int delNew(int nid) {
		String sql = "DELETE FROM news WHERE nid=?";
		int result = newsDao.updateNew(sql, nid);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int updateNew(News news) {
		String sql = "UPDATE news SET ntid=?,ntitle=?,nauthor=?,npicPath=?,ncontent=?,nmodifyDate=?,nsummary=? where nid=?";
		int result = newsDao.updateNew(sql, news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNpicPath(),news.getNcontent(),news.getNmodifyDate(),news.getNsummary(),news.getNid());
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public List<News> findAll() {
		List<News> list = newsDao.findAll();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<News> findByLine(String line, Object param, int strip) {
		List<News> list = newsDao.findByLine(line, param, strip);
		// TODO Auto-generated method stub
		return list;
	}

	
	@Override
	public int count(Integer ntid) {
		int count = newsDao.count(ntid);
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public List<News> findPage(Integer ntid ,int currePageNo, int pageSize) {
		//只需要两个参数即可，当前页面，每页显示行数
		List<News> newsList = new ArrayList<News>();
		int startSelect = (currePageNo - 1) * pageSize;
		StringBuffer sql = new StringBuffer("SELECT * FROM news where 1=1 ");
		if(ntid != null) {
			sql.append("&&ntid=?");
		}
		sql.append(" ORDER BY nmodifyDate DESC LIMIT ?,?");
		//当（？ - 1）*？为0时，显示0-10
		if(ntid != null) {
			newsList = newsDao.findBy(sql.toString(), ntid, startSelect, pageSize);
		}else {
			newsList = newsDao.findBy(sql.toString(), startSelect, pageSize);
		}
		// TODO Auto-generated method stub
		return newsList;
	}

	@Override
	public List<News> findImg() {
		String sql = "SELECT * FROM news where npicPath!='' ORDER BY nmodifyDate limit 4";
		List<News> newsList = newsDao.findBy(sql);
		// TODO Auto-generated method stub
		return newsList;
	}

}
