package co.yedam.board;

public class Board {

	int boardNum;
	String boardName;
	String content;
	String writter;
	
	public int getBoardNum() {
		return boardNum;
	}
	public Board() {}
	public Board(int boardNum, String boardName, String content, String writter) {
		super();
		this.boardNum = boardNum;
		this.boardName = boardName;
		this.content = content;
		this.writter = writter;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritter() {
		return writter;
	}
	public void setWritter(String writter) {
		this.writter = writter;
	}
	public String showInfo() {
		return "글번호: " +boardNum + ", 글제목: " + boardName + ", 작성자: " + writter;
	}
	public String showDetail() {
		String result = "글번호: " +boardNum + ", 글제목: " + boardName + ", 글내용: "+content +", 작성자: " + writter;
		return result;
	}
}
