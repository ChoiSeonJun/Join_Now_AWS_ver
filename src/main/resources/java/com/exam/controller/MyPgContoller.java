package com.exam.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.MyPgDTO;
import com.exam.service.MyPgServiceImpl;

@Controller
//@RequestMapping("/mypage")
public class MyPgContoller {

	@Autowired
	MyPgServiceImpl service;

	// db에 입력해놓은 값 불러오는 건 되는데 문제는 insert로 새로운 값 입력하면 기존값+새로운값 다 출력됨 ㄱ-,,,,,, 
	// 로그인이랑 연동해서 하나만 출력되게 해야되는데,,,
	@GetMapping("/mypage")
	public String mypage(Model m) {
		System.out.println("mypage!!");
		List<MyPgDTO> list = service.mypageList();
		m.addAttribute("mypageList", list);
		return "myPage";
	}
	
	//마이페이지 내용 삽입 - 일단 만들어봄
	@GetMapping("/insertui")
	public String mypageEdit(Model m) {		
		return "myPageAdd";
	}

	
	@PostMapping("/myinsert") 
	  public String mypageInsert(MyPgDTO dto) {
	  System.out.println("mypage 내용추가!!"); 
	  int n = service.mypageInsert(dto);
	  return "redirect:mypage"; 
	  }

	//마이페이지 내용 수정 - 안됨,,!!!
	@GetMapping("/myupdateui")
	public String myupdateui(Model m) {
		System.out.println("mypage 수정!!");
		List<MyPgDTO> list = service.mypageList();
		//MyPgDTO dto = service.mypageUpdate();
		m.addAttribute("mypageList", list);
		return "myPageUpdate";
	}

	
	  @PostMapping("/myupdate") 
	  public String mypageUpdate(MyPgDTO dto) {
	  System.out.println("mypage 내용수정!!"); 
	  int n = service.mypageUpdate(dto);
	  return "redirect:mypage"; 
	  }
	 

}
