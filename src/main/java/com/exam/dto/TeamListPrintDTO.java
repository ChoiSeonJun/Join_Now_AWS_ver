package com.exam.dto;

public class TeamListPrintDTO {

	TeamDTO teamDTO;
	UserInfoDTO userInfoDTO;
	
	public TeamListPrintDTO() {}
	
	public TeamListPrintDTO(TeamDTO teamDTO, UserInfoDTO userInfoDTO) {
		this.teamDTO = teamDTO;
		this.userInfoDTO = userInfoDTO;
	}

	public TeamDTO getTeamDTO() {
		return teamDTO;
	}

	public void setTeamDTO(TeamDTO teamDTO) {
		this.teamDTO = teamDTO;
	}

	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}

	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

	@Override
	public String toString() {
		return "TeamListPrintDTO [teamDTO=" + teamDTO + ", userInfoDTO=" + userInfoDTO + "]";
	}	
	
}
