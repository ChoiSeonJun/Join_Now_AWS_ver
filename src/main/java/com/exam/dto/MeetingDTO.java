package com.exam.dto;

import java.time.LocalDateTime;
import org.apache.ibatis.type.Alias;

@Alias("MeetingDTO")
public class MeetingDTO {

  private int meetingNo;
  private int teamId;
  private String writer;
  private String title;
  private String content;
  private String createdDate;
  private String modifiedDate;



  public MeetingDTO() {}



  public MeetingDTO(int meetingNo, int teamId, String writer, String title, String content,
      String createdDate, String modifiedDate) {
    this.meetingNo = meetingNo;
    this.teamId = teamId;
    this.writer = writer;
    this.title = title;
    this.content = content;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
  }



  public int getMeetingNo() {
    return meetingNo;
  }



  public void setMeetingNo(int meetingNo) {
    this.meetingNo = meetingNo;
  }



  public int getTeamId() {
    return teamId;
  }



  public void setTeamId(int teamId) {
    this.teamId = teamId;
  }



  public String getWriter() {
    return writer;
  }



  public void setWriter(String writer) {
    this.writer = writer;
  }



  public String getTitle() {
    return title;
  }



  public void setTitle(String title) {
    this.title = title;
  }



  public String getContent() {
    return content;
  }



  public void setContent(String content) {
    this.content = content;
  }



  public String getCreatedDate() {
    return createdDate;
  }



  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }



  public String getModifiedDate() {
    return modifiedDate;
  }



  public void setModifiedDate(String modifiedDate) {
    this.modifiedDate = modifiedDate;
  }



  @Override
  public String toString() {
    return "MeetingDTO [meetingNo=" + meetingNo + ", teamId=" + teamId + ", writer=" + writer
        + ", title=" + title + ", content=" + content + ", createdDate=" + createdDate
        + ", modifiedDate=" + modifiedDate + "]";
  }



}
