package com.exam.dto;


public class NotificationPrintDTO {
	NotificationDTO notification;
	UserInfoDTO sender;
	UserInfoDTO receiver;
	
	public NotificationPrintDTO() {}

	public NotificationPrintDTO(NotificationDTO notification, UserInfoDTO sender, UserInfoDTO receiver) {
		this.notification = notification;
		this.sender = sender;
		this.receiver = receiver;
	}

	public NotificationDTO getNotification() {
		return notification;
	}

	public void setNotification(NotificationDTO notification) {
		this.notification = notification;
	}

	public UserInfoDTO getSender() {
		return sender;
	}

	public void setSender(UserInfoDTO sender) {
		this.sender = sender;
	}

	public UserInfoDTO getReceiver() {
		return receiver;
	}

	public void setReceiver(UserInfoDTO receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "NotificationPrintDTO [notification=" + notification + ", sender=" + sender + ", receiver=" + receiver
				+ "]";
	}
	
}
