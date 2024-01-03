package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("TeamDTO")
public class TeamDTO {
  int teamId; // 팀 아이디
  int userId; // 팀장(작성자) 아이디
  String teamName; // 팀 이름
  String teamSubject; // 팀 주제
  String createDate; // 작성 날짜
  String teamLogo; // 팀 로고
  int postNo; // 구인 작성 게시물
  String teamIntro;
  String teamPlan;
  String period;

  public TeamDTO() {}

  public TeamDTO(int teamId, int userId, String teamName, String teamSubject, String createDate,
      String teamLogo, int postNo, String teamIntro, String teamPlan, String period) {
    this.teamId = teamId;
    this.userId = userId;
    this.teamName = teamName;
    this.teamSubject = teamSubject;
    this.createDate = createDate;
    this.teamLogo = teamLogo;
    this.postNo = postNo;
    this.teamIntro = teamIntro;
    this.teamPlan = teamPlan;
    this.period = period;
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

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public String getTeamSubject() {
    return teamSubject;
  }

  public void setTeamSubject(String teamSubject) {
    this.teamSubject = teamSubject;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getTeamLogo() {
    return teamLogo;
  }

  public void setTeamLogo(String teamLogo) {
    this.teamLogo = teamLogo;
  }

  public int getPostNo() {
    return postNo;
  }

  public void setPostNo(int postNo) {
    this.postNo = postNo;
  }

  public String getTeamIntro() {
    return teamIntro;
  }

  public void setTeamIntro(String teamIntro) {
    this.teamIntro = teamIntro;
  }

  public String getTeamPlan() {
    return teamPlan;
  }

  public void setTeamPlan(String teamPlan) {
    this.teamPlan = teamPlan;
  }

  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    this.period = period;
  }

  @Override
  public String toString() {
    return "TeamDTO [teamId=" + teamId + ", userId=" + userId + ", teamName=" + teamName
        + ", teamSubject=" + teamSubject + ", createDate=" + createDate + ", teamLogo=" + teamLogo
        + ", postNo=" + postNo + ", teamIntro=" + teamIntro + ", teamPlan=" + teamPlan + ", period="
        + period + "]";
  }



}
