package com.ezen.spring.service;

import java.util.List;

import com.ezen.spring.domain.LibraryVO;
import com.ezen.spring.domain.PagingVO;

public interface LibraryService {

	List<LibraryVO> getList(PagingVO pgvo);

	int getTotal();

}
