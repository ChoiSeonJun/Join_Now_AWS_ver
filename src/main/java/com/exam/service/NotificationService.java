package com.exam.service;

import java.util.List;

import com.exam.dto.NotificationDTO;

public interface NotificationService {
	
	public int notificationAdd(NotificationDTO dto);
	public List<NotificationDTO> selectListById (int receiveId);
	public int updateIsRead (int notificationId);
	public int deleteAll (int receiveId);
	
}
