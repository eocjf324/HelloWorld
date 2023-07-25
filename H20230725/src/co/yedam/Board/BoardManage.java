package co.yedam.Board;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardManage {
	Scanner scan = new Scanner(System.in);
	List<User> user = new ArrayList<>();
	List<Board> board = new ArrayList<>();

	BoardManage() {
		readtoUser();
		readtoBoard();
	}

	public void login() {
		System.out.println("로그인");
		
		boolean run = true;
		while (run) {
			System.out.print("아이디입력>");
			String id = scan.nextLine();
			System.out.print("비밀번호입력>");
			String pw = scan.nextLine();
			for (int i = 0; i < user.size(); i++) {
				if (user.get(i).getId().equals(id) && user.get(i).getPw().equals(pw)) {
					run = false;
					break;
				}
			}
		}
		System.out.println("로그인 되었습니다.");

	}

	public void readtoUser() {

		try {
			FileReader fr = new FileReader("C:/temp/userList.txt");
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				String str = br.readLine(); // 한문장씩 읽기.

				if (str == null) {
					break;
				}
				String[] data = str.split(" ");
				user.add(new User(data[0], data[1], data[2]));
			}
			System.out.println("유저 정보를 불러옵니다.");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void readtoBoard() {
		try {
			FileReader fr = new FileReader("C:/temp/boardList.txt");
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				String str = br.readLine(); // 한문장씩 읽기.

				if (str == null) {
					break;
				}
				String[] data = str.split(" ");
				board.add(new Board(data[0], data[1], data[2],data[3],data[4]));
			}

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void storeTofile() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/userList.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(user);
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
	public void storeTofile2() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/boardList.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(board);
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
}
