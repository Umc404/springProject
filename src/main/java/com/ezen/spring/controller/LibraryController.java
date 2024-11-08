package com.ezen.spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.spring.domain.LibraryVO;
import com.ezen.spring.domain.PagingVO;
import com.ezen.spring.handler.PagingHandler;
import com.ezen.spring.service.LibraryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/library/*")
@Controller
public class LibraryController {
	
	private final LibraryService lsv;
	
	@GetMapping("/book")
	public String list(Model m, PagingVO pgvo) {
		List<LibraryVO> list = lsv.getList(pgvo);
		log.info(">>>>>>> pgvo >> {}", pgvo);
		int totalCount = lsv.getTotal();
		PagingHandler ph = new PagingHandler(totalCount, pgvo);
		log.info(">>>>>>> total count > {}", totalCount);
		m.addAttribute("list", list);
		m.addAttribute("ph", ph);
		return "/library/book";
	}
}
