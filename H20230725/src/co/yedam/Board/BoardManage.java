package co.yedam.Board;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardManage {
	Scanner scan = new Scanner(System.in);
	List<User> user = new ArrayList<>();
	List<Board> board = new ArrayList<>();
	String id ="";
	BoardManage() {
		readtoUser();
		readtoBoard();
	}

	public void login() {
		System.out.println("로그인");

		boolean run = true;
		while (run) {
			System.out.print("아이디입력>");
			String uid = scan.nextLine();
			System.out.print("비밀번호입력>");
			String pw = scan.nextLine();
			for (int i = 0; i < user.size(); i++) {
				if (user.get(i).getId().equals(id) && user.get(i).getPw().equals(pw)) {
					id = uid; 
					run = false;
					break;
				}
			}
		}
		System.out.println("로그인 되었습니다.");

	}
	
	public void addBoard() {
		System.out.println("글등록");
		System.out.println("번호입력> ");
		String no = scan.nextLine();
		System.out.println("제목입력> ");
		String head = scan.nextLine();
		System.out.println("내용입력> ");
		String content = scan.nextLine();
		String writer = id;
		System.out.println("날짜입력> ");
		String date = scan.nextLine();
		
		board.add(new Board(no, head, content, writer, date));
	}
	
	public void editBoard() {
		System.out.println("글등록");
		System.out.println("번호입력> ");
		String no = scan.nextLine();
		int check = -1;
		for(int i= 0; i< board.size(); i++) {
			if(board.get(i).getNo().equals(no)) {
				System.out.println("수정할 내용입력> ");
				String content = scan.nextLine();
				board.get(i).setContent(content);
				check = 1;
				break;
			}
		}
		if(check == -1) {
			System.out.println("수정되지 않았습니다.");
		}else {
			System.out.println("수정되었습니다.");
		}
	}
	public void delBoard() {
		System.out.println("글삭제");
		System.out.println("번호입력> ");
		String no = scan.nextLine();
		int check = -1;
		for(int i= 0; i< board.size(); i++) {
			if(board.get(i).getNo().equals(no)) {
				board.remove(i);
				check = 1;
				break;
			}
		}
		if(check == -1) {
			System.out.println("삭제되지 않았습니다.");
		}else {
			System.out.println("삭제되었습니다.");
		}
	}
	List<Board> list(){
		return board;
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
				board.add(new Board(data[0], data[1], data[2], data[3], data[4]));
			}

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void storeToUser() {
		try {
			FileWriter fw = new FileWriter("C:/temp/userList.txt");
			BufferedWriter br = new BufferedWriter(fw);

			for (User user : user) {
				String data = user.getId() + " " + user.getName() + " " + user.getPw();
				br.write(data + "\n");
			}
			br.flush();
			br.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void storeToBoard() {
		FileWriter fw;
		try {
			fw = new FileWriter("C:/temp/boardList.txt");
			BufferedWriter br = new BufferedWriter(fw);

			for (Board board : board) {
				String data = board.getNo() + " " + board.getHead() + " " + board.getContent() + " " + board.getWriter()
						+ " " + board.getDate();
				br.write(data + "\n");

				br.flush();
				br.close();
				fw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}