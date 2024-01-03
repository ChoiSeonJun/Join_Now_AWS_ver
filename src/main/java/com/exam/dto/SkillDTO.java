package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("SkillDTO")
public class SkillDTO {
	
	int applyNo;
	int skillNo;
	String skill;
	
	public SkillDTO() {}

	public SkillDTO(int applyNo, String skill) {
		this.applyNo = applyNo;
		this.skill = skill;
	}

	public int getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}

	public int getSkillNo() {
		return skillNo;
	}

	public void setSkillNo(int skillNo) {
		this.skillNo = skillNo;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "SkillDTO [applyNo=" + applyNo + ", skillNo=" + skillNo + ", skill=" + skill + "]";
	}
	
}
