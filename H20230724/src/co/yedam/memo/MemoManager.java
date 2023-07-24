package co.yedam.memo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoManager {

	Scanner scan = new Scanner(System.in);
	List<Memo> memoStorage = new ArrayList<>();

	//생성자
	public MemoManager() {
		readFromFile();
	}

	public void printMenu() {
		System.out.println("1.등록 2.검색 3.삭제 4.조회 5.종료");
		System.out.print("번호입력>");
	}

	// 메모번호
	public int getNextNo() {
		int no = 0;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getNo() > no) {
				no = memoStorage.get(i).getNo();
			}
		}
		return no + 1;
	}
	
	// 1.등록기능
	public void inputData() {
		int no = getNextNo();
		System.out.print("날짜>> ");
		String date = scan.nextLine();
		System.out.print("내용>> ");
		String content = scan.nextLine();

		Memo memo = null;
		if (date.isEmpty()) {
			memo = new Memo(no, content);
		} else {
			memo = new Memo(no, date, content);
		}

		if (memoStorage.add(memo)) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}// end of inputDate

	// 입력된 날짜의 메모 출력
	public void searchData() {
		System.out.print("날짜>> ");
		String date = scan.nextLine();
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getDate().equals(date)) {
				System.out.println(memoStorage.get(i).toString());
			}
		}

	}

	public void memoList() {

		for (int i = 0; i < memoStorage.size(); i++) {
			System.out.println(memoStorage.get(i).toString());
		}
	}

	public void deleteData() {

		System.out.print("번호>> ");
		int no = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getNo() == no) {
				memoStorage.remove(i);
			}
		}

	}

	// 출력스트림 (객체)
	public void stroeTofile() {

		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/memo.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(memoStorage);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
			System.out.println("종료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}                                                                    

	// 불러옴(객체)
	private void readFromFile() {

		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/temp/memo.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			memoStorage = (List<Memo>) ois.readObject();
			ois.close();
			fis.close();

		} catch (Exception e) {
//			e.printStackTrace();
		}

	}
}
