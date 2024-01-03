package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("NotificationDTO")
public class NotificationDTO {
	int notificationId;
	int sendId;
	int receiveId;
	String content;
	boolean isRead;
	int postId;
	String date;
	
	public NotificationDTO() {}

	public NotificationDTO(int notificationId, int sendId, int receiveId, String content, boolean isRead, int postId,
			String date) {
		super();
		this.notificationId = notificationId;
		this.sendId = sendId;
		this.receiveId = receiveId;
		this.content = content;
		this.isRead = isRead;
		this.postId = postId;
		this.date = date;
	}

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public int getSendId() {
		return sendId;
	}

	public void setSendId(int sendId) {
		this.sendId = sendId;
	}

	public int getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "NotificationDTO [notificationId=" + notificationId + ", sendId=" + sendId + ", receiveId=" + receiveId
				+ ", content=" + content + ", isRead=" + isRead + ", postId=" + postId + ", date=" + date + "]";
	}
		
	
}
