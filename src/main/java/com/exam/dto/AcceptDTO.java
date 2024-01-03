package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("AcceptDTO")
public class AcceptDTO {
	int applicationNo;
	int applyUserId; // 신청자
	int acceptUserId; // 작성자
	boolean accept; // 수락 여부
	int postNo; // 게시판 넘버
	int applyNo; // 신청서 넘버
	
	public AcceptDTO() {}

	public AcceptDTO(int applicationNo, int applyUserId, int acceptUserId, boolean accept, int postNo, int applyNo) {
		this.applicationNo = applicationNo;
		this.applyUserId = applyUserId;
		this.acceptUserId = acceptUserId;
		this.accept = accept;
		this.postNo = postNo;
		this.applyNo = applyNo;
	}

	public int getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
	}

	public int getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(int applyUserId) {
		this.applyUserId = applyUserId;
	}

	public int getAcceptUserId() {
		return acceptUserId;
	}

	public void setAcceptUserId(int acceptUserId) {
		this.acceptUserId = acceptUserId;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public int getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}

	@Override
	public String toString() {
		return "AcceptDTO [applicationNo=" + applicationNo + ", applyUserId=" + applyUserId + ", acceptUserId="
				+ acceptUserId + ", accept=" + accept + ", postNo=" + postNo + ", applyNo=" + applyNo + "]";
	}
	
	
}
