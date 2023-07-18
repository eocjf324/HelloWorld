package co.yedam.memo;

public class Memo {
	String memoNum;
	String content;
	String date;
	
	public String getMemoNum() {
		return memoNum;
	}
	public void setMemoNum(String memoNum) {
		this.memoNum = memoNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Memo(String memoNum, String content, String date) {
		super();
		this.memoNum = memoNum;
		this.content = content;
		this.date = date;
	}
	public Memo() {
		
	}
	
	
}
