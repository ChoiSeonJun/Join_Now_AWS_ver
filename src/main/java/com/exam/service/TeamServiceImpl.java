package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.TeamDAO;
import com.exam.dto.TeamDTO;
import com.exam.dto.TeamMemberDTO;

@Service
public class TeamServiceImpl implements TeamService {

  @Autowired
  TeamDAO dao;

  @Override
  public int teamAdd(TeamDTO dto) {
    return dao.teamAdd(dto);
  }

  @Override
  public int teamMemberAdd(TeamMemberDTO dto) {
    return dao.teamMemberAdd(dto);
  }

  @Override
  public TeamDTO selectByPostNo(int postNo) {
    return dao.selectByPostNo(postNo);
  }


  @Override
  public List<Integer> selectTeamIdByUserId(int userId) {
    return dao.selectTeamIdByUserId(userId);
  }

  @Override
  public TeamDTO selectByTeamId(int teamId) {
    return dao.selectByTeamId(teamId);
  }

  @Override
  public List<TeamMemberDTO> selectMemberListByTeamId(int teamId) {
    return dao.selectMemberListByTeamId(teamId);
  }

  @Override
  public int teamMemberDel(int userId) {
    return dao.teamMemberDel(userId);
  }
  
  // 팀페이지 팀 정보 수정
  @Override
  public int updateTeamInfoById(TeamDTO teamDTO) {
    return dao.updateTeamInfoById(teamDTO);
  }

  // 팀 삭제
  @Override
  public int deleteTeamByteamId(int teamId) {
    return dao.deleteTeamByteamId(teamId); //dao.deleteTeamByteamId(teamId);
  }

  // 모든 팀원 삭제
  @Override
  public int deleteTeamMemberByteamId(int teamId) {
    return dao.deleteTeamMemberByteamId(teamId); //dao.deleteTeamByteamId(teamId);
  }
}
