package co.dc.test.book.service;

import lombok.Data;

@Data
public class BookVO {
	String bkCode;
	String bkTitle;
	String bkAuthor;
	String bkPress;
	int bkPrice;
}
