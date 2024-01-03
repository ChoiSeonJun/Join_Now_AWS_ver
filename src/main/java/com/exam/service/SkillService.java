package com.exam.service;

import java.util.List;

import com.exam.dto.ApplyDTO;
import com.exam.dto.SkillDTO;

public interface SkillService {

	public int skillAdd(ApplyDTO dto, List<SkillDTO> list);
	public List<SkillDTO> skillList(int applyNo);
}
