package com.exam.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("PageDTO")
public class PageDTO {
	List<PostDTO> list; // 한 페이지의 리스트 정보
	int curPage; // 현재 페이지 정보
	int perPage = 6; // 리스트의 개수
	int totalCount; // 전체 리스트의 개수
	int pageNum; // 총 페이지의 개수
	
	// 생성자
	public PageDTO() {}
	
	public PageDTO(List<PostDTO> list, int curPage, int perPage, int totalCount, int pageNum) {
		super();
		this.list = list;
		this.curPage = curPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
		this.pageNum = pageNum;
	}
	
	// getter setter
	public List<PostDTO> getList() {
		return list;
	}

	public void setList(List<PostDTO> list) {
		this.list = list;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	
	
	
	
}
