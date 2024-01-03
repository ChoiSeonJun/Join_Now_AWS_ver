package com.exam.dto;

import org.apache.ibatis.type.Alias;



@Alias("MyPgDTO")
public class MyPgDTO {
	
	String userid;
	String email;
	String nickname;
	String phone;
	String pofolLink;
	String skills;
	String tools;
	String intro;
	
	public MyPgDTO() {}

	public MyPgDTO(String userid, String email, String nickname, String phone, String pofolLink, String skills,
			String tools, String intro) {
		this.userid = userid;
		this.email = email;
		this.nickname = nickname;
		this.phone = phone;
		this.pofolLink = pofolLink;
		this.skills = skills;
		this.tools = tools;
		this.intro = intro;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPofolLink() {
		return pofolLink;
	}

	public void setPofolLink(String pofolLink) {
		this.pofolLink = pofolLink;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "MyPgDTO [userid=" + userid + ", email=" + email + ", nickname=" + nickname + ", phone=" + phone
				+ ", pofolLink=" + pofolLink + ", skills=" + skills + ", tools=" + tools + ", intro=" + intro + "]";
	}
	
	
	
	
}
