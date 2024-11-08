package com.ezen.spring.dao;

import java.util.List;

import com.ezen.spring.domain.LibraryVO;
import com.ezen.spring.domain.PagingVO;

public interface LibraryDAO {

	List<LibraryVO> getList(PagingVO pgvo);

	int getTotal();

}
