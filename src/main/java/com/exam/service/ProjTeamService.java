package com.exam.service;

import java.util.HashMap;
import java.util.List;
import com.exam.dto.MeetingDTO;
import com.exam.dto.MeetingPageDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;


public interface ProjTeamService {

  // 일정표
  public int selectAi(); // Auto_Increment 값 추출
  
  public int selectIdById(int id); // schedule 테이블의 id값 추출

  public int insertEvent(HashMap<String, Object> map); // 이벤트 저장

  public List<ScheduleDTO> selectAllEventbyId(int teamId); // 이벤트 조회

  public int updateEvent(ScheduleDTO scheduleDTO); // 이벤트 수정

  public int deleteEvent(ScheduleDTO scheduleDTO); // 이벤트 삭제

  // 회의록
  public MeetingPageDTO getAllPost(HashMap<String, Integer> hashmap); // 회의록 목록 조회 + 페이징 처리

  public int addMeetingPost(MeetingDTO meetingDTO); // 회의록 작성

  public MeetingDTO selectOneById(HashMap<String, Integer> map); // 상세페이지

  public int deleteOneById(HashMap<String, Integer> map); // 회의록 삭제

  public int updateMeetingById(HashMap<String, Object> map); // 희의록 수정
  
  public List<MeetingDTO> searchAll(HashMap<String, Object> map); // 회의록 검색 - 전체
  
  public List<MeetingDTO> searchTitle(HashMap<String, Object> map); // 회의록 검색 - 제목
  
  public List<MeetingDTO> searchContent(HashMap<String, Object> map); // 회의록 검색 - 내용

  // 팀 정보

}
