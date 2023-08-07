package co.dc.project.boardprj.board.service;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BoardVO {

	private int boardId;
	private String boardWriter;
	private String boardTitle;
	private String boardSubject;
	private LocalDate boardDate;
	private int boardHit;

	public String toString() { //리스트조회
		System.out.print(boardId + "\t ");
		System.out.print(boardWriter + "\t ");
		System.out.print(boardTitle + "\t ");

		if (boardSubject.length() > 8) {
			String temp = boardSubject.substring(0, 8);
			temp += "....";
			System.out.print(temp + "\t ");
		} else {
			System.out.print(boardSubject + "\t ");
		}
		System.out.print(boardDate + "\t  ");
		System.out.println(boardHit + "\t ");

		return null;
	}

	public String toString2() {  //단건조회
		System.out.print(boardId + "\t ");
		System.out.print(boardWriter + "\t ");
		System.out.print(boardTitle + "\t ");
		System.out.print(boardDate + "\t");
		System.out.println(boardHit + "\t ");
		System.out.println(boardSubject + "\t ");
		return null;
	}
}
