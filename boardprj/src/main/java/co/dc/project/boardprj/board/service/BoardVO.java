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
	
	public String toString() {
		System.out.print(boardId + " ");
		System.out.print(boardWriter + " ");
		System.out.print(boardTitle + " ");
		if(boardSubject != null) {
			System.out.print(boardSubject + " ");
		}	
		System.out.print(boardDate + " ");
		System.out.println(boardHit + " ");
		return null;
	}

}
