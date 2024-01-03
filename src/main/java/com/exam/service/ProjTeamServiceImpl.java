package com.exam.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.exam.dao.ProjTeamDAO;
import com.exam.dto.MeetingDTO;
import com.exam.dto.MeetingPageDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;

@Service
public class ProjTeamServiceImpl implements ProjTeamService {

  @Autowired
  ProjTeamDAO dao;


  /**
   * 일정표
   *    
   * 일정 추가
   * 일정 조회
   * 일정 수정
   * 일정 삭제
   */
  // 마지막 일정
  public int selectAi() {
   return dao.selectAi(); 
  }
  
  // 중복 체크
  public int selectIdById(int id) {
    return dao.selectIdById(id);
  }
  
  
  // 일정 추가
  @Override
  public int insertEvent(HashMap<String, Object> map) {
    return dao.insertEvent(map);
  }

  // 일정 조회
  @Override
  public List<ScheduleDTO> selectAllEventbyId(int teamId) {
    try {
      return dao.selectAllEventbyId(teamId);
    }catch (NullPointerException e) {
      return null;
    } 
  }

  // 일정 수정
  @Override
  public int updateEvent(ScheduleDTO scheduleDTO) {
    return dao.updateEvent(scheduleDTO);
  }

  // 일정 삭제
  @Override
  public int deleteEvent(ScheduleDTO scheduleDTO) {
    try {
      return dao.deleteEvent(scheduleDTO);
    }catch (NullPointerException e) {
      return 0;
    } 
  }

  /**
   * 희의록
   * 
   * 조회
   */

  // 조회
  @Override
  public MeetingPageDTO getAllPost(HashMap<String, Integer> hashmap) {
    return dao.getAllPost(hashmap);
  }
  
  // 추가
  @Override
  public int addMeetingPost(MeetingDTO meetingDTO) {
    return dao.addMeetingPost(meetingDTO);
  }
  
  // 삭제
  @Override
  public int deleteOneById(HashMap<String, Integer> map) {
    return dao.deleteOneById(map);
  }
  

  // 자세히보기
  @Override
  public MeetingDTO selectOneById(HashMap<String, Integer> map) {
    return dao.selectOneById(map);
  }

  // 수정
  @Override
  public int updateMeetingById(HashMap<String, Object> map){
    return dao.updateMeetingById(map);
  }
  
  // 검색 - 전체
  @Override
  public List<MeetingDTO> searchAll(HashMap<String, Object> map) {
    return dao.searchAll(map);
  }
  
  // 검색 - 제목
  @Override
  public List<MeetingDTO> searchTitle(HashMap<String, Object> map) {
    return dao.searchTitle(map);
  }
  
  // 검색 - 내용
  @Override
  public List<MeetingDTO> searchContent(HashMap<String, Object> map) {
    return dao.searchContent(map);
  }


}
