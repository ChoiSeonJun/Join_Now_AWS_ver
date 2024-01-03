package com.exam.service;

import java.util.List;

import com.exam.dto.AcceptDTO;
import com.exam.dto.PageDTO;

public interface AcceptService {
	public List<AcceptDTO> selectListApplyUser(int userid);
	public List<AcceptDTO> selectListAcceptUser(int userid);
	public int acceptAdd(AcceptDTO dto);
	public int acceptApplyDel(int applyNo, int applicationNo);
}
