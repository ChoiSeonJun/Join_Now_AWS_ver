package com.exam.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.TestDTO;
import com.exam.service.TestServiceImpl;


@Controller
public class TestContoller {
		
	/*
		기존 SpringFramework의  application scope 사용
		   1) implements ServletContextAware
		   2) @Override
		   
		public void setServletContext(ServletContext servletContext) {
			this.application = servletContext;
		}
	*/
	
	@Autowired
	TestServiceImpl service;
	
/*	@GetMapping("/main")
	public String main() {
		List<TestDTO> list = service.testSelect();
		for(TestDTO i : list) {
			System.out.println(i.getId());
			System.out.println(i.getPw());
		}
		
		System.out.println("*************");
		return "main";
	}
	*/
}
