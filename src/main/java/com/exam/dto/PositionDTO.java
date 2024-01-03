package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("PositionDTO")
public class PositionDTO {
	
	int postNo;
	String category;
	String recruitType;
	String memberSize;
	int positionNo;
	
	public PositionDTO() {}

	public PositionDTO(int postNo) {
		this.postNo = postNo;
	}

	public PositionDTO(int postNo, String category, String recruitType, String memberSize) {
		this.postNo = postNo;
		this.category = category;
		this.recruitType = recruitType;
		this.memberSize = memberSize;
	}
	

	public int getPositionNo() {
		return positionNo;
	}

	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRecruitType() {
		return recruitType;
	}

	public void setRecruitType(String recruitType) {
		this.recruitType = recruitType;
	}

	public String getMemberSize() {
		return memberSize;
	}

	public void setMemberSize(String memberSize) {
		this.memberSize = memberSize;
	}

	@Override
	public String toString() {
		return "PositionDTO [postNo=" + postNo + ", category=" + category + ", recruitType=" + recruitType
				+ ", memberSize=" + memberSize + ", positionNo=" + positionNo + "]";
	}
	


	
	
}
