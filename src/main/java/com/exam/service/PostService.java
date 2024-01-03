package com.exam.service;

import java.util.HashMap;
import java.util.List;

import com.exam.dto.PostDTO;

public interface PostService {
	public List<PostDTO> postList();
	public int postAdd(PostDTO dto);
	public PostDTO postListbyNo(int postNo);
	public int postUpdate(PostDTO dto);
	public int viewCount(int postNo);
	public int postDelete(HashMap<String, Object> map);
	public List<PostDTO> postListbyId(int userId);
}
