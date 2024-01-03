package com.exam.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Alias("QuestionDTO")
public class QuestionDTO {

  private int id;
//  private UserDTO author; // 질문 작성자 정보
  private String writer;
  private String title;
  private String content;
  private String createdAt;
//  private List<AnswerDTO> answers; // 질문에 대한 답변 목록

  public QuestionDTO() {}


  public QuestionDTO(int id, String writer, String title, String content, String createdDated) {
    this.id = id;
    this.writer = writer;
    this.title = title;
    this.content = content;
    this.createdAt = createdDated;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdDated) {
    this.createdAt = createdDated;
  }



}
