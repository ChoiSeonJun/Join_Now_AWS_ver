package com.exam.dto;
import org.apache.ibatis.type.Alias;
@Alias("MyPgDTO")
public class MyPgDTO {

    int id;
    String email;
    String nickname;
    String phone;
    String pofolLink;
    String skills;
    String tools;
    String intro;
    public MyPgDTO() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public MyPgDTO(int id, String email, String nickname, String phone, String pofolLink, String skills, String tools,
			String intro) {
		super();
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.phone = phone;
		this.pofolLink = pofolLink;
		this.skills = skills;
		this.tools = tools;
		this.intro = intro;
	}
	@Override
	public String toString() {
		return "MyPgDTO [id=" + id + ", email=" + email + ", nickname=" + nickname + ", phone=" + phone + ", pofolLink="
				+ pofolLink + ", skills=" + skills + ", tools=" + tools + ", intro=" + intro + "]";
	}

}