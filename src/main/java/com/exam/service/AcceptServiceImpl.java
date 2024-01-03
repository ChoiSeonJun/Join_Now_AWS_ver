package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.AcceptDAO;
import com.exam.dto.AcceptDTO;
import com.exam.dto.PageDTO;

@Service
public class AcceptServiceImpl implements AcceptService {
	
	@Autowired
	AcceptDAO dao;
	
	// 테이블 추가 
	@Override
	public int acceptAdd(AcceptDTO dto) {
		return dao.acceptAdd(dto);
	}

	// 테이블 출력
	@Override
	public List<AcceptDTO> selectListApplyUser(int userid) {
		return dao.selectListApplyUser(userid);
	}
	
	public List<AcceptDTO> selectListAcceptUser(int userid){
		return dao.selectListAcceptUser(userid);
	}

	@Override
	public int acceptApplyDel(int applyNo, int applicationNo) {
		return dao.acceptApplyDel(applyNo, applicationNo);
	}
	
	
}
