package com.exam.service;

import java.util.List;

import com.exam.dto.PageDTO;
import com.exam.dto.PostDTO;

public interface MainService {
	public PageDTO selectList(int curPage);
	public PageDTO searchTitle(int curPage, String keyword);
}
