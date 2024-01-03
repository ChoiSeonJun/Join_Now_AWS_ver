package com.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.PageDTO;
import com.exam.dto.PostDTO;

@Repository
public class MainDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public int totalCount() {
		return session.selectOne("MainMapper.totalCount");
	}
	
	public int totalCountTitle() {
		return session.selectOne("MainMapper.totalCountTitle");
	}
	
	public PageDTO selectList(int curPage){
		PageDTO pageDTO = new PageDTO();
		// pageDTO.setPerPage(11); => 한 페이지의 리스트 개수를 11개로 설정
		// RowBounds(offset, limit) 한 페이지에 나오는 리스트 개수 만큼, List<PostDTO> list에 담는다. 
		int offset = (curPage-1)*pageDTO.getPerPage(); // 시작지점, 끝지점
		int limit = pageDTO.getPerPage(); // 6
		List<PostDTO> list2 =  session.selectList("MainMapper.selectList");
		
		list2=mergeSort(list2);
						
		List<PostDTO> list = new ArrayList<PostDTO>();
		
		for(int i=offset;i<(offset+limit);i++) {
			
			list.add(list2.get(i));
			
			if(i==list2.size()-1){
				break;
			}
		}
		
		
		pageDTO.setList(list);
		pageDTO.setCurPage(curPage);
		pageDTO.setTotalCount(totalCount());
		
		// 페이지 개수 조정 -> 설정을 안하고 설계를 하면 리스트가 6개일 경우 페이지가 1장만 있으면 모두 출력 가능하지만 2장이 출력되게끔 밖에 설계가 불가능함.
		// 그래서 if문을 사용하여 페이징을 처리 함.
		if(totalCount()%pageDTO.getPerPage()==0) {
			pageDTO.setPageNum(totalCount()/pageDTO.getPerPage());
		}else {
			pageDTO.setPageNum(totalCount()/pageDTO.getPerPage()+1);
		}
		
		if(totalCount()==0) {
			pageDTO.setPageNum(1);
		}
		
		return pageDTO;
	}
	
	public PageDTO searchTitle(int curPage, String keyword) {
		PageDTO pageDTO = new PageDTO();
		// pageDTO.setPerPage(11); => 한 페이지의 리스트 개수를 11개로 설정
		// RowBounds(offset, limit) 한 페이지에 나오는 리스트 개수 만큼, List<PostDTO> list에 담는다. 
		int offset = (curPage-1)*pageDTO.getPerPage(); // 시작지점, 끝지점
		int limit = pageDTO.getPerPage(); // 6
		List<PostDTO> list2 =  session.selectList("MainMapper.searchTitle", keyword);
		
		list2=mergeSort(list2);
						
		List<PostDTO> list = new ArrayList<PostDTO>();
		
		for(int i=offset;i<(offset+limit);i++) {
			
			list.add(list2.get(i));
			
			if(i==list2.size()-1){
				break;
			}
		}
		
		
		pageDTO.setList(list);
		pageDTO.setCurPage(curPage);
		pageDTO.setTotalCount(totalCountTitle());
		
		// 페이지 개수 조정 -> 설정을 안하고 설계를 하면 리스트가 6개일 경우 페이지가 1장만 있으면 모두 출력 가능하지만 2장이 출력되게끔 밖에 설계가 불가능함.
		// 그래서 if문을 사용하여 페이징을 처리 함.
		if(totalCountTitle()%pageDTO.getPerPage()==0) {
			pageDTO.setPageNum(totalCountTitle()/pageDTO.getPerPage());
		}else {
			pageDTO.setPageNum(totalCountTitle()/pageDTO.getPerPage()+1);
		}
		
		if(totalCountTitle()==0) {
			pageDTO.setPageNum(1);
		}
		
		return pageDTO;
	}
	
	// 병합 정렬 알고리즘 (조회수로 정렬)
    public static List<PostDTO> mergeSort(List<PostDTO> list) {
        if (list.size() <= 1) return list; // 리스트가 비어있거나 이미 정렬되어 있으면 종료

        int mid = list.size() / 2;
        List<PostDTO> left = new ArrayList<>(list.subList(0, mid));
        List<PostDTO> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left); // 왼쪽 부분을 재귀적으로 정렬
        right = mergeSort(right); // 오른쪽 부분을 재귀적으로 정렬

        return merge(left, right); // 정렬된 부분을 병합
    }

    public static List<PostDTO> merge(List<PostDTO> left, List<PostDTO> right) {
        List<PostDTO> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
        	// 값을 비교 하는 부분
            if (left.get(i).getViewCount() >= right.get(j).getViewCount()) { // 값 비교
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i++));
        }

        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }
}
