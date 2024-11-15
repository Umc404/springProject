package com.ezen.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.spring.dao.BoardDAO;
import com.ezen.spring.domain.BoardVO;
import com.ezen.spring.domain.PagingVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDAO bdao;
	
	@Override
	public List<BoardVO> getFreeList(PagingVO pgvo) {
		log.info(">>>>>> 2 {}", pgvo);
		return bdao.getFreeList(pgvo);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return bdao.getTotal();
	}

	@Override
	public List<BoardVO> getNoticeList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getNoticeList(pgvo);
	}

}
