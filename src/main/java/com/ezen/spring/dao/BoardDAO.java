package com.ezen.spring.dao;

import java.util.List;

import com.ezen.spring.domain.BoardVO;
import com.ezen.spring.domain.PagingVO;

public interface BoardDAO {

	List<BoardVO> getFreeList(PagingVO pgvo);

	int getTotal();

}
