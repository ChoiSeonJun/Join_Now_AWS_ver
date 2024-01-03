package com.exam.service;

import java.util.List;

import com.exam.dto.PositionDTO;
import com.exam.dto.PostDTO;

public interface PositionService {
	public List<PositionDTO> positionList(int postNo);
	public int positionOneAdd(PositionDTO dto);
	public int positionAdd(PostDTO dto, List<PositionDTO> list);
//	public int positionAdd(int postNo, PostDTO dto, PositionDTO dto2);
//	public int positionUpdate(PositionDTO dto);
	public int positionDelete(int postNo);

}
