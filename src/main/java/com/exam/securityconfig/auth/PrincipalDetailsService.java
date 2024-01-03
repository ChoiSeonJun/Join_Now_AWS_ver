package com.exam.securityconfig.auth;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.repository.UserRepository;
import com.exam.securitymodel.User;

// 시큐리티 설정에서 /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어있는 loadUserByUsername 함수가 실행
// Username 즉 로그인할 때 id를 받아오는 역할이다. (이건 고정되어있기때문에 username이라고 무조건 고정시켜야한다.)
// 사실 SecurityConfig에서 .usernameParameter("") 설정해주면 가능하긴 하다
@Service
public class PrincipalDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username); // findByUsername은 jpa를 사용해서 사용 (UserRepository)
		if(user == null) {
			return null;
		}else {
			return new PrincipalDetails(user);
		}
		
	}

}
