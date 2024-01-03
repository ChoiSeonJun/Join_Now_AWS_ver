package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("TeamMemberDTO")
public class TeamMemberDTO {
	int teamMemberId;
	int teamId;
	int userId;
	
	public TeamMemberDTO() {}

	public TeamMemberDTO(int teamMemberId, int teamId, int userId) {
		this.teamMemberId = teamMemberId;
		this.teamId = teamId;
		this.userId = userId;
	}

	public int getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(int teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "TeamMemberDTO [teamMemberId=" + teamMemberId + ", teamId=" + teamId + ", userId=" + userId + "]";
	}
		
}
