package com.ezen.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.spring.dao.LibraryDAO;
import com.ezen.spring.domain.LibraryVO;
import com.ezen.spring.domain.PagingVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class LibraryServiceImpl implements LibraryService {
	private final LibraryDAO ldao;

	@Override
	public List<LibraryVO> getList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return ldao.getList(pgvo);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return ldao.getTotal();
	}
}
