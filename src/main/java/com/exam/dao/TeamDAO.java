package com.exam.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.TeamDTO;
import com.exam.dto.TeamMemberDTO;

@Repository
public class TeamDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public int teamAdd(TeamDTO dto) {
		return session.insert("TeamMapper.teamAdd", dto);
	}
	
	public int teamMemberAdd(TeamMemberDTO dto) {
		return session.insert("TeamMapper.teamMemberAdd",dto);
	}
	
	public TeamDTO selectByPostNo(int postNo) {
		return session.selectOne("TeamMapper.selectByPostNo", postNo);
	}
	

	// 팀 정보 출력
	public TeamDTO selectByTeamId(int teamId) {
	    return session.selectOne("TeamMapper.selectByTeamId", teamId);
	}
	
	public List<Integer> selectTeamIdByUserId(int userId){
		return session.selectList("TeamMapper.selectTeamIdByUserId", userId);
	}
	
	// 팀 멤버 정보 출력
	public List<TeamMemberDTO> selectMemberListByTeamId(int teamId){
		return session.selectList("TeamMapper.selectMemberListByTeamId", teamId);		
	}
	
	// 팀 멤버 삭제
	public int teamMemberDel(int userId) {
		return session.delete("TeamMapper.teamMemberDel", userId);
	}
	
	// 팀 정보 수정
	public int updateTeamInfoById(TeamDTO teamDTO) {
	  return session.update("TeamMapper.updateTeamInfoById", teamDTO);
	}
	
	// 팀 삭제
	public int deleteTeamByteamId(int teamId) {
	  return session.delete("TeamMapper.deleteTeamByteamId", teamId);
	}
	
	// 팀 멤버 전체 삭제
    public int deleteTeamMemberByteamId(int teamId) {
      return session.delete("TeamMapper.deleteTeamMemberByteamId", teamId);      
    }
}
