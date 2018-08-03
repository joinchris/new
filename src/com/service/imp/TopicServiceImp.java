package com.service.imp;
import java.util.List;

import com.dao.TopicDao;
import com.dao.imp.TopicDaoImp;
import com.entity.Topic;
import com.service.TopicService;

public class TopicServiceImp implements TopicService{
	TopicDao topicDao = new TopicDaoImp();

	@Override
	public int addTopic(Topic topic) {
		String sql = "INSERT INTO topic(tname) VALUES(?)";
		int result = topicDao.updateTopic(sql, topic.getTname());
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int delTopic(int tid) {
		String sql = "DELETE FROM topic where tid=?";
		int result = topicDao.updateTopic(sql, tid);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int updateTopic(Topic topic) {
		String sql = "UPDATE topic SET tname=? where tid=?";
		int result = topicDao.updateTopic(sql, topic.getTname(),topic.getTid());
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public List<Topic> findAll() {
		List<Topic> list = topicDao.findAll();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Topic findByLine(String line, Object param) {
		// TODO Auto-generated method stub
		List<Topic> list = topicDao.findByLine(line, param);
		if(list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

}
