package com.exam.service;

import java.util.List;

import com.exam.dto.CommentDTO;

public interface CommentService {

	public int commentAdd(CommentDTO dto);
	public List<CommentDTO> commentListbyNo(int postNo);
	public int commentUpdate(CommentDTO dto);
	public int commentDelete(int commentNo);
	public CommentDTO commentListbyCno(int commentNo);
	
}
