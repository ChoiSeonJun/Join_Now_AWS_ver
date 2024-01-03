package com.exam.controller;

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

import com.exam.dto.PageDTO;
import com.exam.dto.PostDTO;
import com.exam.service.MainServiceImpl;


@Controller
public class LoginController {
		
		
	@GetMapping("/loginPage")
	public String main() {
		return "loginForm";
	}
	
}
