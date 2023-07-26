package co.yedam.board;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BoardApp {

	List<Board> list = new ArrayList<>();

	BoardApp() {
		readToFile();
	}
	public boolean register(Board board) {

		list.add(board);
		return true;
	}

	public int getNo() {
		int no = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getbNo() > no)
				no = list.get(i).getbNo();
		}
		return no + 1;
	}

	public boolean modify(Board board) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getbNo() == board.getbNo()) {
				list.get(i).setContent(board.getContent());
				return true;
			}
		}
		return false;
	}

	public String search(int bno) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getbNo() == bno) {
				return list.get(i).toString();
			}
		}
		return null;
	}

	public boolean remove(int bno) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getbNo() == bno) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

	List<Board> list() {
		return list;
	}


	public void readToFile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/temp/boardList.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (List<Board>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
		}

	}

	public void writeToFile() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/boardList.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
