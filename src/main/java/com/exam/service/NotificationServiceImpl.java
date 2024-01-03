package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.NotificationDAO;
import com.exam.dto.NotificationDTO;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	NotificationDAO dao;

	@Override
	public int notificationAdd(NotificationDTO dto) {
		return dao.notificationAdd(dto);
	}

	@Override
	public List<NotificationDTO> selectListById(int receiveId) {
		return dao.selectListById(receiveId);
	}

	@Override
	public int updateIsRead(int notificationId) {
		return dao.updateIsRead(notificationId);
	}

	@Override
	public int deleteAll(int receiveId) {
		return dao.deleteAll(receiveId);
	}
	
	
}
