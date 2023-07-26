package co.yedam.boardpkg;

public class Board {
	private int brdNo;
	private String title;
	private String content;
	private String writer;
	private String writeDate;

	public Board() {
		
	}

	public Board(int brdNo, String title, String content, String writer, String writeDate) {
		super();
		this.brdNo = brdNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
	}

	public Board(int brdNo, String content) {
		this.brdNo = brdNo;
		this.content = content;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
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

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "게시판 번호 : " + brdNo + ", 제목 : " + title + ", 내용 : " + content + ", 글쓴이 : " + writer
				+ ", 작성날짜 : " + writeDate;
	}

}
