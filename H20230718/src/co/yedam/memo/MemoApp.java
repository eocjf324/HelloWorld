package co.yedam.memo;

import cd.yedam.student.Student;

public class MemoApp {

	Memo[] memos;
	int memoNumber = 0;

	MemoApp() {
		memos = new Memo[10];
	}

//	void addMemo(Memo m) {
//		memos[memoNumber++] = m;
//	}

	boolean addMemo(Memo memo) {

		if (memoNumber >= 10) { 
			return false;
		}
		memos[memoNumber++ ] = memo;
		return true;
	}
	boolean editMemo(String num, String content) {
		for (int i = 0; i < memos.length; i++) {
			if (memos[i] != null && memos[i].memoNum.equals(num)) {

				memos[i].setContent(content);
				return true;
			}
		}
		return false;
	}

	boolean delMemo(String num) {
		for (int i = 0; i < memos.length; i++) {
			if (memos[i] != null && memos[i].memoNum.equals(num)) {

				memos[i] = null;
				return true;
			}
		}
		return false;
	}
	Memo[] MemoList(){
		return memos;
	}
	String findMemo(String num) {
		for (int i = 0; i < memos.length; i++) {
			if (memos[i] != null && memos[i].memoNum.equals(num)) {
				String result =memos[i].content; 
				return result;
			}
		}
		return null;
	}
}
