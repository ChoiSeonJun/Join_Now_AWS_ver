package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exam.dto.TeamDTO;
import com.exam.dto.TeamListPrintDTO;
import com.exam.dto.TeamMemberDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.service.TeamService;
import com.exam.service.UserService;

@Controller
public class TeamController {
	@Autowired
	TeamService service;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/teamList")
	public String teamList(Model m, HttpSession session) {
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		int userId = userInfoDTO.getId();
		List<TeamListPrintDTO> teamList = new ArrayList<TeamListPrintDTO>();
		List<Integer> teamIdList = service.selectTeamIdByUserId(userId);
		
		for(int i : teamIdList) {
			TeamDTO Tdto = service.selectByTeamId(i); // 팀 dto
			TeamListPrintDTO dto = new TeamListPrintDTO();
			dto.setTeamDTO(service.selectByTeamId(i)); // 팀 dto
			dto.setUserInfoDTO(userService.selectAllById(Tdto.getUserId()));
			
			teamList.add(dto);
		}
				
		m.addAttribute("teamList", teamList);
		return "teamList";
	}
	
	@GetMapping("/teamManage")
	public String teamManage(Model m, HttpSession session, int teamId) {
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		List<TeamMemberDTO> memberList = service.selectMemberListByTeamId(teamId);
		
		List<UserInfoDTO> userList = new ArrayList<UserInfoDTO>();
		for(TeamMemberDTO dto : memberList) {
			userList.add(userService.selectAllById(dto.getUserId()));
		}
		
		TeamDTO teamDTO = service.selectByTeamId(teamId); 
		boolean leader = false;
		if(userInfoDTO.getId() == teamDTO.getUserId()) {
			leader=true;
		}
		
		System.out.println(leader);
		m.addAttribute("memberList", userList);
		m.addAttribute("leader", leader);
		m.addAttribute("teamId", teamId);
			
		return "TeamManagementPage";
	}
	
	@GetMapping("/memberDelete")
	public String teamMemberDelete(int userId, int teamId) {
		service.teamMemberDel(userId);
				
		return "redirect:teamManage?teamId="+teamId;
	}
	
}
