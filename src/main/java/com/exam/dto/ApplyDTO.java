package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("ApplyDTO")
public class ApplyDTO {
	
	int userid;
	String applyType;
	String contact;
	String content;
	int applyNo;
	int postNo;
	String date;
	
	public ApplyDTO() {}

	public ApplyDTO(int userid, String applyType, String contact, String content, int applyNo, int postNo,
			String date) {
		this.userid = userid;
		this.applyType = applyType;
		this.contact = contact;
		this.content = content;
		this.applyNo = applyNo;
		this.postNo = postNo;
		this.date = date;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ApplyDTO [userid=" + userid + ", applyType=" + applyType + ", contact=" + contact
				+ ", content=" + content + ", applyNo=" + applyNo + ", postNo=" + postNo + ", date=" + date + "]";
	}
	
	
}
