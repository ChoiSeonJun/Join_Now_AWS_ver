package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.MyPgDAO;
import com.exam.dto.MyPgDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPgServiceImpl implements MyPgService {
	
	@Autowired
	MyPgDAO dao;

//	@Override
//	public MyPgDTO selectList() {
//		return dao.selectList();
//	}


	@Override
	public List<MyPgDTO> mypageList() {
		return dao.mypageList();		
	}


	@Override
	public int mypageInsert(MyPgDTO dto) {
		return dao.mypageInsert(dto);
	}


	@Override
	public int mypageUpdate(MyPgDTO dto) {
		return dao.mypageUpdate(dto);
	}


}
