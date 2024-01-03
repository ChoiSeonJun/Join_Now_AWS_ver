package com.exam.service;

import java.util.HashMap;
import java.util.List;

import com.exam.dto.ApplyDTO;

public interface ApplyService {

	public int applyAdd(ApplyDTO dto);
	public List<ApplyDTO> selectListApplyByIdAndPostNo(HashMap<String, Integer> map);
	public ApplyDTO selectOne(int applyNo);
}
