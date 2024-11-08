package com.ezen.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	
	private long bno;
	private String bcls;
	private String title;
	private String writer;
	private String content;
	private String isDel;
	private String regDate;
	private String modDate;
	private int readCnt;
	private int cmtQty;
}
