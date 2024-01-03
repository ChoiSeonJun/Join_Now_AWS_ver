package com.exam.securitycontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.dto.UserInfoDTO;
import com.exam.repository.UserRepository;
import com.exam.securityconfig.auth.PrincipalDetails;
import com.exam.securitymodel.User;
import com.exam.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	UserService service;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping({ "", "/app" })
	public String index(
			Authentication authentication, @AuthenticationPrincipal PrincipalDetails userDetails,
			HttpSession session, Model m){
		
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("authentication:" + principalDetails.getUser());
        User user = principalDetails.getUser();
        System.out.println(user.getEmail());
        
        UserInfoDTO dto = service.selectAll(user.getUsername());
        System.out.println(dto);
        
        session.setAttribute("loginInfo", dto);
        m.addAttribute("UserInfo", dto);
		
        if(dto.getNickname()==null) {
        	service.updateNickname(dto);
        }
        
        return "redirect:main";
        
		
	}

	@GetMapping("/user")
	public @ResponseBody String user(@AuthenticationPrincipal PrincipalDetails principal) {
		System.out.println("Principal : " + principal);
//		System.out.println("OAuth2 : "+principal.getUser().getProvider());
//		// iterator 순차 출력 해보기
//		Iterator<? extends GrantedAuthority> iter = principal.getAuthorities().iterator();
//		while (iter.hasNext()) {
//			GrantedAuthority auth = iter.next();
//			System.out.println(auth.getAuthority());
//		}

		return "유저 페이지입니다.";
	}

	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "어드민 페이지입니다.";
	}
	
	//@PostAuthorize("hasRole('ROLE_MANAGER')")
	//@PreAuthorize("hasRole('ROLE_MANAGER')")
	@Secured("ROLE_MANAGER")
	@GetMapping("/manager")
	public @ResponseBody String manager() {
		return "매니저 페이지입니다.";
	}

	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}

	@GetMapping("/join")
	public String join() {
		return "joinForm";
	}

	@PostMapping("/joinProc")
	public String joinProc(User user, HttpSession session) {
		System.out.println("회원가입 진행 : " + user);
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER");
		userRepository.save(user);
		
		// 회원가입과 동시에 세션에 데이터 저장
		UserInfoDTO dto = service.selectAll(user.getUsername());
		
		service.updateNickname(dto);
		
		
		return "redirect:login";
	}
	
	// 아이디 중복 확인
	@GetMapping(value="/UserIdCheckServlet", 
				produces = "text/plain;charset=utf-8") // 한글이 깨져서 utf-8설정
	@ResponseBody // 응답을 jsp가 아닌 일반 데이터(문자열, JSON 형태)로 전송
	public String idCheck(@RequestParam("username")
								String username) {
		User user = service.idCheck(username);
		
		String mesg = "아이디 사용 가능";
		if(user!=null) {
			mesg = "아이디 중복";
		}
		
		return mesg; //@ResponseBody이니 문자열로 리턴하고, .jsp는 맵핑값을 따라간다  
		// /WEB-INF/views/MemberIdCheckServlet.jsp
		}
}
