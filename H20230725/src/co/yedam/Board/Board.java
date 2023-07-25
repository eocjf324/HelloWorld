package co.yedam.Board;

import java.io.Serializable;

public class Board implements Serializable{
	String no;
	String head;
	String content;
	String writer;
	String date;
	
	
	public Board(String no,String head, String content, String writer, String date) {
		this.no = no;
		this.head = head;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
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
	
}
