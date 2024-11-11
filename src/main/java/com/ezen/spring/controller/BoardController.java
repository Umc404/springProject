package com.ezen.spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.spring.domain.BoardVO;
import com.ezen.spring.domain.PagingVO;
import com.ezen.spring.handler.PagingHandler;
import com.ezen.spring.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	private final BoardService bsv;
	
	@GetMapping("/register")
	public void register() {}
	
	@GetMapping("/free")
	public String freeList(Model m, PagingVO pgvo) {
		log.info(">>>>>> 1 {}", pgvo);
		List<BoardVO> list = bsv.getFreeList(pgvo);
		int totalCount = bsv.getTotal();
		PagingHandler ph = new PagingHandler(totalCount, pgvo);
		log.info(">>> totalCount > {}", totalCount);
		log.info(">>>>>>>>>>> pgvo > {}", pgvo);
		m.addAttribute("list", list);
		m.addAttribute("ph", ph);
		log.info(">>>>>>>>>>> m > {}", m);
		return "/board/free";
	}
	
	@GetMapping("/notice")
	public String noticeList(Model m, PagingVO pgvo) {
		log.info(">>>>>> 1 {}", pgvo);
		List<BoardVO> list = bsv.getNoticeList(pgvo);
		int totalCount = bsv.getTotal();
		PagingHandler ph = new PagingHandler(totalCount, pgvo);
		log.info(">>> totalCount > {}", totalCount);
		log.info(">>>>>>>>>>> pgvo > {}", pgvo);
		m.addAttribute("list", list);
		m.addAttribute("ph", ph);
		log.info(">>>>>>>>>>> m > {}", m);
		return "/board/notice";
	}
	
//	public String notice
}
