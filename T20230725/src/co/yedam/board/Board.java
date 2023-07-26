package co.yedam.board;

import java.io.Serializable;

public class Board implements Serializable{
	int bNo;
	String title;
	String content;
	String writer;
	String date;
	
	public Board(int bNo, String content) {
		this.bNo = bNo;
		this.content = content;
	}
	public Board(int bNo, String title, String content, String writer, String date) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "게시판 번호 : " + bNo + ", 제목 :" + title + ", 내용 :" + content + ", 글쓴이 :" + writer + ", 작성날짜 :"
				+ date;
	}
	
}
