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
public class LibraryVO {
	
//	id int auto_increment,
//	set_isbn_no varchar(13) not null,
//	each_isbn_no varchar(13) not null,
//	book_num varchar(100) not null,
//	title_name varchar(256),
//	origin_isbn_no varchar(50),
	
	private long id;
	private String setIsbnNo;
	private String eachIsbnNo;
	private String bookNum;
	private String titleName;
	private String originIsbnNo;
}
