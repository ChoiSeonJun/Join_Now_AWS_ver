package com.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.dto.MyPgDTO;



public interface MyPgService {
	
//	public MyPgDTO selectList();
	public List<MyPgDTO> mypageList();
	public int mypageInsert(MyPgDTO dto);
	public int mypageUpdate(MyPgDTO dto);
	
}
