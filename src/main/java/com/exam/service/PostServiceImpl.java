package com.exam.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.PositionDAO;
import com.exam.dao.PostDAO;
import com.exam.dto.PostDTO;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostDAO dao;

	@Override
	public List<PostDTO> postList() {
		return dao.postList();
	}

	@Override
	public int postAdd(PostDTO dto) {
		return dao.postAdd(dto);
	}

	@Override
	public PostDTO postListbyNo(int postNo) {
		return dao.postListbyNo(postNo);
	}

	@Override
	public int postUpdate(PostDTO dto) {
		return dao.postUpdate(dto);
	}

	@Override
	public int viewCount(int postNo) {
		return dao.viewCount(postNo);
	}

	@Override
	public int postDelete(HashMap<String, Object> map) {
		return dao.postDelete(map);
	}

	@Override
	public List<PostDTO> postListbyId(int userId) {
		return dao.postListbyId(userId);
	}


}
