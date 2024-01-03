package com.exam.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.NotificationDTO;

@Repository
public class NotificationDAO {
	@Autowired
	SqlSessionTemplate session;
	
	public int notificationAdd(NotificationDTO dto) {
		return session.insert("NotificationMapper.notificationAdd", dto);	
	}
	
	public List<NotificationDTO> selectListById (int receiveId){
		return session.selectList("NotificationMapper.selectListById", receiveId);
	}
	
	public int updateIsRead (int notificationId) {
		return session.update("NotificationMapper.updateIsRead",notificationId);
	}
	
	public int deleteAll (int receiveId) {
		return session.delete("NotificationMapper.deleteAll", receiveId);
	}
}
