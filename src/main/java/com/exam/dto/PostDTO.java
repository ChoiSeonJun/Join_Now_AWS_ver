package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("PostDTO")
public class PostDTO {
	
	int postNo;
	String title;
	String studyType;
	String onoff;
	String region;
	String content;
	int userid;
	boolean closing;
	String postDate;
	int viewCount;
	String deadline;
	String startDate;
	String contact;
	String nickname;
	
	public PostDTO() {}

	public PostDTO(int postNo, String title, String studyType, String onoff, String region, String content,
			int userid, boolean closing, String postDate, int viewCount, String deadline, String startDate,
			String contact) {
		this.postNo = postNo;
		this.title = title;
		this.studyType = studyType;
		this.onoff = onoff;
		this.region = region;
		this.content = content;
		this.userid = userid;
		this.closing = closing;
		this.postDate = postDate;
		this.viewCount = viewCount;
		this.deadline = deadline;
		this.startDate = startDate;
		this.contact = contact;
	}
	

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudyType() {
		return studyType;
	}

	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}

	public String getOnoff() {
		return onoff;
	}

	public void setOnoff(String onoff) {
		this.onoff = onoff;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public boolean isClosing() {
		return closing;
	}

	public void setClosing(boolean closing) {
		this.closing = closing;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "PostDTO [postNo=" + postNo + ", title=" + title + ", studyType=" + studyType + ", onoff=" + onoff
				+ ", region=" + region + ", content=" + content + ", userid=" + userid + ", closing=" + closing
				+ ", postDate=" + postDate + ", viewCount=" + viewCount + ", deadline=" + deadline + ", startDate="
				+ startDate + ", contact=" + contact + ", nickname=" + nickname + "]";
	}



	
}
