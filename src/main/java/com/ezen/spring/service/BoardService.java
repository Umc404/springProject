package com.ezen.spring.service;

import java.util.List;

import com.ezen.spring.domain.BoardVO;
import com.ezen.spring.domain.PagingVO;

public interface BoardService {

	List<BoardVO> getFreeList(PagingVO pgvo);

	int getTotal();

	List<BoardVO> getNoticeList(PagingVO pgvo);

}
