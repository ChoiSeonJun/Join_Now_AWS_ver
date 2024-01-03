package com.exam.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Alias("ProjDTO")
public class ProjDTO {

  private int id;
  private String title;
  private String intro;
  private String porcess;
  private String tMember;
  
  public ProjDTO(int id, String title, String intro, String porcess, String tMember) {
    this.id = id;
    this.title = title;
    this.intro = intro;
    this.porcess = porcess;
    this.tMember = tMember;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public String getPorcess() {
    return porcess;
  }

  public void setPorcess(String porcess) {
    this.porcess = porcess;
  }

  public String gettMember() {
    return tMember;
  }

  public void settMember(String tMember) {
    this.tMember = tMember;
  }
  
  
  
}
