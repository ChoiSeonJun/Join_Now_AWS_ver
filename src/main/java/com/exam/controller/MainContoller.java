package com.exam.controller;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.NotificationDTO;
import com.exam.dto.PageDTO;
import com.exam.dto.PostDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.navercloud.openapi.service.ObjectStorageService;
import com.exam.service.MainServiceImpl;
import com.exam.service.NotificationService;


@Controller
public class MainContoller {
		
	/*
		기존 SpringFramework의  application scope 사용
		   1) implements ServletContextAware
		   2) @Override
		   
		public void setServletContext(ServletContext servletContext) {
			this.application = servletContext;
		}
	*/
	
	@Autowired
	MainServiceImpl service;
		

	
	@GetMapping("/main")
	public String main(@RequestParam(value = "curPage", required = false, defaultValue = "1")int curPage,
						Model m) {
		
		PageDTO pageDTO = service.selectList(curPage);
		
		m.addAttribute("pageDTO", pageDTO);

		//메인에 보여지는 게시글 설명 글자수 제한 후 화면단으로 정보 전달
		List<PostDTO> list = pageDTO.getList();
		List<String> truncatedContentList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String content = list.get(i).getContent();
		    if (content.length() > 50) {
		        content = content.substring(0, 50) + "...";
		    }
		    truncatedContentList.add(content);
        }
		m.addAttribute("truncatedContentList", truncatedContentList);
				
		return "main";
	}
	
	@GetMapping("/searchMain")
	public String searchMain(@RequestParam(value = "curPage", required = false, defaultValue = "1")int curPage, @RequestParam String keyword,
			Model m) {
		
		PageDTO pageDTO = service.searchTitle(curPage, keyword);
		
		m.addAttribute("pageDTO", pageDTO);

		//메인에 보여지는 게시글 설명 글자수 제한 후 화면단으로 정보 전달
		List<PostDTO> list = pageDTO.getList();
		List<String> truncatedContentList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String content = list.get(i).getContent();
		    if (content.length() > 50) {
		        content = content.substring(0, 50) + "...";
		    }
		    truncatedContentList.add(content);
        }
		m.addAttribute("truncatedContentList", truncatedContentList);
		return "main";
	}
	
}
