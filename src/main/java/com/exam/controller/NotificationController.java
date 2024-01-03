package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.NotificationDTO;
import com.exam.dto.NotificationPrintDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.service.NotificationService;
import com.exam.service.UserService;

@Controller
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	UserService userSerivce;
	
	@GetMapping("/notification")
	public String notification(Model m, HttpSession session) {
		// 로그인 정보 -> 수신자
		UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
		// 세션에서 id값 받아오기
		int id = userInfoDTO.getId();
		// 현재 로그인된 id에 해당하는 정보 받아와서 출력
		UserInfoDTO info = userSerivce.selectAllById(id);
		m.addAttribute("userInfoDTO", info);
		
		List<NotificationDTO> notificationList = notificationService.selectListById(userInfoDTO.getId());
				
		List<NotificationPrintDTO> NPList = new ArrayList<NotificationPrintDTO>();
		
		for(NotificationDTO notification : notificationList) {
			NotificationPrintDTO NPdto = new NotificationPrintDTO();
			NPdto.setNotification(notification);
			NPdto.setSender(userSerivce.selectAllById(notification.getSendId()));
			NPdto.setReceiver(userSerivce.selectAllById(notification.getReceiveId()));
			
			NPList.add(NPdto);
		}
				
		m.addAttribute("notificationPrintList", NPList);
		
		return "notificationPage";
	}
	
	@PostMapping("/notificationCheck")
	public String notificationCheck(int notificationId) {
		System.out.println(notificationId);
		int n = notificationService.updateIsRead(notificationId);
		return "redirect:notification";
	}

	@PostMapping("/notificationDeleteAll")
	public String notificationDeleteAll(HttpSession session) {
		// 로그인 정보 -> 수신자
		UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
		notificationService.deleteAll(userInfoDTO.getId());
		return "redirect:notification";
	}
}
