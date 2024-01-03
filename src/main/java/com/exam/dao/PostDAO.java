package com.exam.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.PostDTO;

@Repository
public class PostDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<PostDTO> postList(){
		return session.selectList("PostMapper.postList");
	}
	
	public int postAdd(PostDTO dto){
		return session.insert("PostMapper.postAdd", dto);
	}
	
	public PostDTO postListbyNo(int postNo){
		return session.selectOne("PostMapper.postListbyNo", postNo);
	}
	
	public int postUpdate(PostDTO dto){
		return session.update("PostMapper.postUpdate", dto);
	}
	
	public int viewCount(int postNo) {
		return session.update("PostMapper.viewCount", postNo);
	}
	
	public int postDelete(HashMap<String, Object> map) {
		return session.update("PostMapper.postDelete", map);
	}
	
	public List<PostDTO> postListbyId(int userId){
		return session.selectList("PostMapper.postListbyId", userId);
	}
	
}
