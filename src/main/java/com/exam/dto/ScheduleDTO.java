package com.exam.dto;

import org.apache.ibatis.type.Alias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Alias("ScheduleDTO")
public class ScheduleDTO {
  private int id;
  private int teamId;
  private String title;
  private String start;
  private String end;
  private String backgroundColor;

  public ScheduleDTO() {}

  public ScheduleDTO(int id, int teamId, String title, String start, String end,
      String backgroundColor) {
    this.id = id;
    this.teamId = teamId;
    this.title = title;
    this.start = start;
    this.end = end;
    this.backgroundColor = backgroundColor;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTeamId() {
    return teamId;
  }

  public void setTeamId(int teamId) {
    this.teamId = teamId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public String getBackgroundColor() {
    return backgroundColor;
  }

  public void setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

  @Override
  public String toString() {
    return "ScheduleDTO [id=" + id + ", teamId=" + teamId + ", title=" + title + ", start=" + start
        + ", end=" + end + ", backgroundColor=" + backgroundColor + "]";
  }


}
