package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dao.SkillDAO;
import com.exam.dto.ApplyDTO;
import com.exam.dto.SkillDTO;

@Service
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	SkillDAO dao;


	@Override
	@Transactional
	public int skillAdd(ApplyDTO dto, List<SkillDTO> list) {
		return dao.skillAdd(dto, list);
	}


	@Override
	public List<SkillDTO> skillList(int applyNo) {
		return dao.skillList(applyNo);
	}


}
