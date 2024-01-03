package com.exam.securityconfig.auth;

import java.util.ArrayList;


import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.exam.securitymodel.User;





// Authentication 객체에 저장할 수 있는 유일한 타입
public class PrincipalDetails implements UserDetails, OAuth2User{

//	private static final long serialVersionUID = 1L;
	private User user;
	private Map<String, Object> attributes;

	// 일반 시큐리티 로그인시 사용
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	// OAuth2.0 로그인시 사용
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		this.user = user;
		this.attributes = attributes;
	}
	
	public User getUser() {
		return user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 이 계정이 만료되었는가?
	@Override
	public boolean isAccountNonExpired() {
		return true; // 아니오
	}

	// 이 계정이 잠겼는가?
	@Override
	public boolean isAccountNonLocked() {
		return true; // 아니오
	}

	// 이 계정의 비밀번호 유효기간이 지났는가?
	@Override
	public boolean isCredentialsNonExpired() {
		return true; // 아니오
	}

	// 이 계정이 활성화 잠겨있는가?
	@Override
	public boolean isEnabled() {
		return true; // 아니오
	}
	 
	// 해당 User의 권한을 리턴하는 곳
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
		collet.add(()->{ return user.getRole();});
		return collet;
	}

	// 리소스 서버로 부터 받는 회원정보
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	// User의 PrimaryKey
	@Override
	public String getName() {
		return user.getId()+"";
	}
	
}
