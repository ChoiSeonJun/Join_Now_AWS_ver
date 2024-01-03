package com.exam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.AcceptDTO;
import com.exam.dto.AcceptPrintDTO;
import com.exam.dto.ApplyDTO;
import com.exam.dto.NotificationDTO;
import com.exam.dto.PostDTO;
import com.exam.dto.SkillDTO;
import com.exam.dto.TeamDTO;
import com.exam.dto.TeamMemberDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.service.AcceptService;
import com.exam.service.ApplyService;
import com.exam.service.NotificationService;
import com.exam.service.PostService;
import com.exam.service.SkillService;
import com.exam.service.TeamService;
import com.exam.service.UserService;

@Controller
public class AcceptController {
		
	@Autowired
	AcceptService acceptService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@Autowired 
	ApplyService applyService;
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	SkillService skillService;
	
	@GetMapping("/applyPage")
	public String applyPage(Model m, HttpSession session) {
		// 로그인 정보 확인
		UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
		// 로그인 유저 아이디와 작성자 id를 비교해서 리스트를 들고옴 -> 작성자가 받은 신청자 내역확인
		List<AcceptDTO> acceptDTOList = acceptService.selectListApplyUser(userInfoDTO.getId());
		
		// 콘솔에 신청자 정보 출력
		System.out.println("########################");
		for(AcceptDTO acceptdto : acceptDTOList) {
			System.out.println(acceptdto);
		}
		
		// 출력 dto를 가진 리스트 생성
		List<AcceptPrintDTO> acceptPrintList = new ArrayList<>();
		
		// 출력 dto를 가진 리스트에 값저장 acceptDTOList에 있는 정보를 accpetdto에 저장해서 그 정보를 바탕으로 이용해서
		// 출력 dto에 신청자, 작성자, 게시판 정보, 신청 정보 저장
		for(AcceptDTO acceptdto : acceptDTOList) {
			AcceptPrintDTO printdto = new AcceptPrintDTO();
			printdto.setAcceptDTO(acceptdto);
			printdto.setAcceptUserInfoDTO(userService.selectAllById(acceptdto.getAcceptUserId()));
			printdto.setApplyUserInfoDTO(userService.selectAllById(acceptdto.getApplyUserId()));
			printdto.setPostDTO(postService.postListbyNo(acceptdto.getPostNo()));
			printdto.setApplyDTO(applyService.selectOne(acceptdto.getApplyNo()));
						
			acceptPrintList.add(printdto);
		}
		
		for(AcceptPrintDTO printdto : acceptPrintList) {
			System.out.println(printdto);
		}
		
		m.addAttribute("acceptPrintList",acceptPrintList);
		
		return "applyPage";
	}
	
	@GetMapping("/acceptPage")
	public String acceptPage(Model m, HttpSession session) {
		// 로그인 정보 -> 수신자
		UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
		// 세션에서 id값 받아오기
		int id = userInfoDTO.getId();
		// 현재 로그인된 id에 해당하는 정보 받아와서 출력
		UserInfoDTO info = userService.selectAllById(id);
		m.addAttribute("userInfoDTO", info);
		// 로그인 유저 아이디와 작성자 id를 비교해서 리스트를 들고옴 -> 작성자가 받은 신청자 내역확인
		List<AcceptDTO> acceptDTOList = acceptService.selectListAcceptUser(userInfoDTO.getId());
		
		// 콘솔에 신청자 정보 출력
		System.out.println("########################");
		for(AcceptDTO acceptdto : acceptDTOList) {
			System.out.println(acceptdto);
		}
		
		// 출력 dto를 가진 리스트 생성
		List<AcceptPrintDTO> acceptPrintList = new ArrayList<>();
		
		// 출력 dto를 가진 리스트에 값저장 acceptDTOList에 있는 정보를 accpetdto에 저장해서 그 정보를 바탕으로 이용해서
		// 출력 dto에 신청자, 작성자, 게시판 정보, 신청 정보 저장
		for(AcceptDTO acceptdto : acceptDTOList) {
			AcceptPrintDTO printdto = new AcceptPrintDTO();
			printdto.setAcceptDTO(acceptdto);
			printdto.setAcceptUserInfoDTO(userService.selectAllById(acceptdto.getAcceptUserId()));
			printdto.setApplyUserInfoDTO(userService.selectAllById(acceptdto.getApplyUserId()));
			printdto.setPostDTO(postService.postListbyNo(acceptdto.getPostNo()));
			printdto.setApplyDTO(applyService.selectOne(acceptdto.getApplyNo()));
						
			acceptPrintList.add(printdto);
		}
		
		for(AcceptPrintDTO printdto : acceptPrintList) {
			System.out.println(printdto);
		}
		
		m.addAttribute("acceptPrintList",acceptPrintList);
		
		return "acceptPage";
	}
	
	@GetMapping("/applyRetrieve")
	public String applyRetrieve(Model m, int applyNo){
		ApplyDTO dto = applyService.selectOne(applyNo);
		List<SkillDTO> skillList = skillService.skillList(dto.getApplyNo());
		
		m.addAttribute("applyDTO", dto);		
		m.addAttribute("UserInfoDTO", userService.selectAllById(dto.getUserid()));
		m.addAttribute("skillList",skillList);
		
		return "applyRetrieve";
	}
	
	@GetMapping("/acceptYN")
	public String acceptYN(int applyNo, int applicationNo, String YN, int applyUserId, int postNo, HttpSession session) {
		System.out.println(applyNo); // 신청서 정보
		System.out.println(applicationNo); // 신청 정보
		System.out.println(YN);
		System.out.println(applyUserId);
		System.out.println(postNo);
		
		// 로그인 정보 -> 작성자
		UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
		
		// 수락하면 팀원 정보 등록
		if(YN.equals("수락")) {
			TeamDTO teamDTO = teamService.selectByPostNo(postNo);
			TeamMemberDTO teamMemberDTO = new TeamMemberDTO();
			teamMemberDTO.setTeamId(teamDTO.getTeamId());
			teamMemberDTO.setUserId(applyUserId);			
			teamService.teamMemberAdd(teamMemberDTO);
			
			// 알림 전송
			NotificationDTO notificationDTO = new NotificationDTO();
			notificationDTO.setSendId(userInfoDTO.getId()); // 작성자
			notificationDTO.setReceiveId(applyUserId); // 신청자
			notificationDTO.setContent("신청을 수락 하였습니다.");
			notificationDTO.setPostId(postNo); // 공고 정보
			
			notificationService.notificationAdd(notificationDTO);
			
		}else {
			// 알림 전송
			NotificationDTO notificationDTO = new NotificationDTO();
			notificationDTO.setSendId(userInfoDTO.getId()); // 작성자
			notificationDTO.setReceiveId(applyUserId); // 신청자
			notificationDTO.setContent("신청을 거절 하였습니다.");
			notificationDTO.setPostId(postNo); // 공고 정보
			
			notificationService.notificationAdd(notificationDTO);
			
		}
		
		acceptService.acceptApplyDel(applyNo, applicationNo); // 신청 정보, 신청서 삭제 
		
		return "redirect:acceptPage";
	}
	
		
}
