package com.exam.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.exam.dto.MeetingDTO;
import com.exam.dto.MeetingPageDTO;
import com.exam.dto.PageDTO;
import com.exam.dto.PostDTO;
import com.exam.dto.TeamDTO;
import com.exam.dto.TeamDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;



@Repository
public class ProjTeamDAO {

  @Autowired
  SqlSessionTemplate session;

  /**
   * 일정표
   */
  // auto_increment 값
  public int selectAi() {
    return session.selectOne("ProjTeamMapper.selectAi");

  }

  // 중복 체크
  public int selectIdById(int id) {
    try {
      return session.selectOne("ProjTeamMapper.selectIdById", id);
    } catch (NullPointerException e) {
      return 0;
    }

  }

  // 일정 추가
  public int insertEvent(HashMap<String, Object> map) {
    return session.insert("ProjTeamMapper.insertEvent", map);
  }

  // 일정 조회
  public List<ScheduleDTO> selectAllEventbyId(int teamId) {
    return session.selectList("ProjTeamMapper.selectAllEventbyId", teamId);
  }

  // 일정 수정
  public int updateEvent(ScheduleDTO scheduleDTO) {
    return session.update("ProjTeamMapper.updateEvent", scheduleDTO);
  }

  // 일정 수정
  public int deleteEvent(ScheduleDTO scheduleDTO) {
    return session.delete("ProjTeamMapper.deleteEvent", scheduleDTO);
  }


  /**
   * 회의록
   */
  // 희의록 row 총 개수
  public int totalCount() {
    return session.selectOne("ProjTeamMapper.totalCount");
  }

  // 회의록 조회
  public MeetingPageDTO getAllPost(HashMap<String, Integer> hashmap) {
    MeetingPageDTO pageDTO = new MeetingPageDTO();
    // pageDTO.setPerPage(11); => 한 페이지의 리스트 개수를 11개로 설정
    // RowBounds(offset, limit) 한 페이지에 나오는 리스트 개수 만큼, List<PostDTO> list에 담는다.
    int offset = (hashmap.get("curPage") - 1) * pageDTO.getPerPage();
    int limit = pageDTO.getPerPage();
    List<MeetingDTO> list = session.selectList("ProjTeamMapper.selectAllPostById", hashmap,
        new RowBounds(offset, limit));

    pageDTO.setList(list);
    pageDTO.setCurPage(hashmap.get("curPage"));
    pageDTO.setTotalCount(totalCount());

    // 페이지 개수 조정 -> 설정을 안하고 설계를 하면 리스트가 6개일 경우 페이지가 1장만 있으면 모두 출력 가능하지만 2장이 출력되게끔 밖에 설계가 불가능함.
    // 그래서 if문을 사용하여 페이징을 처리 함.
    if (totalCount() % pageDTO.getPerPage() == 0) {
      pageDTO.setPageNum(totalCount() / pageDTO.getPerPage());
    } else {
      pageDTO.setPageNum(totalCount() / pageDTO.getPerPage() + 1);
    }

    if (totalCount() == 0) {
      pageDTO.setPageNum(1);
    }

    return pageDTO;
  }

  // 회의록 추가
  public int addMeetingPost(MeetingDTO meetingDTO) {
    return session.insert("ProjTeamMapper.addMeetingPost", meetingDTO);
  }

  // 회의록 자세히 보기
  public MeetingDTO selectOneById(HashMap<String, Integer> map) {
    return session.selectOne("ProjTeamMapper.selectOneById", map);
  }

  // 희의록 삭제
  public int deleteOneById(HashMap<String, Integer> map) {
    return session.delete("ProjTeamMapper.deleteOneById", map);
  }

  // 회의록 수정
  public int updateMeetingById(HashMap<String, Object> map) {
    return session.update("ProjTeamMapper.updateMeetingById", map);
  }

  // 회의록 검색 - 전체
  public List<MeetingDTO> searchAll(HashMap<String, Object> map) {
    return session.selectList("ProjTeamMapper.searchAll", map);
  }

  // 회의록 검색 - 제목
  public List<MeetingDTO> searchTitle(HashMap<String, Object> map) {
    return session.selectList("ProjTeamMapper.searchTitle", map);
  }

  // 회의록 검색 - 내용
  public List<MeetingDTO> searchContent(HashMap<String, Object> map) {
    return session.selectList("ProjTeamMapper.searchContent", map);
  }



  // 프로젝트 팀 페이지 - 프로젝트 팀 정보 얻기
  public TeamDTO selectAllbyId() {
    return session.selectOne("ProjTeamMapper.selectAllbyId");
  }

}
