package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dao.PositionDAO;
import com.exam.dto.PositionDTO;
import com.exam.dto.PostDTO;

@Service
public class PositionServiceImpl implements PositionService {
	
	@Autowired
	PositionDAO dao;
	
	

	@Override
	public List<PositionDTO> positionList(int postNo) {
		return dao.positionList(postNo);
	}

	@Override
	@Transactional
	public int positionAdd(PostDTO dto, List<PositionDTO> list) {
		return dao.positionAdd(dto, list);
	}
	
//	@Override
//	@Transactional
//	public int positionAdd(int postNo, PostDTO dto, PositionDTO dto2) {
//		return dao.positionAdd(postNo, dto, dto2);
//	}
	

//	@Override
//	public int positionUpdate(PositionDTO dto) {
//		return dao.positionUpdate(dto);
//	}

	@Override
	public int positionDelete(int postNo) {
		return dao.positionDelete(postNo);
	}

	@Override
	public int positionOneAdd(PositionDTO dto) {
		return dao.positionOneAdd(dto);
	}

	
	
}
