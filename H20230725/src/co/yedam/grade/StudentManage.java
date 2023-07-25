package co.yedam.grade;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManage {
	
	StudentManage(){
		 readTofile();
	}

	Scanner scan = new Scanner(System.in);
	List<Student> list = new ArrayList<>();
	String result = "";
	int check = 1;
	public void insertStudent() {
		System.out.println("학생정보입력");
		System.out.print("학번>");
		int snum = Integer.parseInt(scan.nextLine());
		for(int i=0; i< list.size(); i++) {
			if(list.get(i).getsNum() == snum) {
				System.out.println("존재하는 학번입니다.");
				check = -1;
			}
		}
		if(check == 1) {
			System.out.print("이름>");
			String sname = scan.nextLine();
			System.out.print("국어>");
			int kor = Integer.parseInt(scan.nextLine());
			System.out.print("영어>");
			int eng = Integer.parseInt(scan.nextLine());
			System.out.print("수학>");
			int math = Integer.parseInt(scan.nextLine());

			list.add(new Student(snum, sname, kor, eng, math));
		}
	}
	public void insertScore() {
		check = -1;
		System.out.print("학번>");
		int snum = Integer.parseInt(scan.nextLine());
		
		for(int i=0; i< list.size(); i++) {
			if(list.get(i).getsNum() == snum) {
				System.out.println("성적입력");
				System.out.print("국어>");
				int kor = Integer.parseInt(scan.nextLine());
				System.out.print("영어>");
				int eng = Integer.parseInt(scan.nextLine());
				System.out.print("수학>");
				int math = Integer.parseInt(scan.nextLine());
				
				list.get(i).setKor(kor);
				list.get(i).setEng(eng);
				list.get(i).setMath(math);
				System.out.println("성적이 입력되었습니다.");
				check = 1;
				break;
			}
		}
		if(check == -1) {
			System.out.println("학번을 찾을수 없습니다.");
		}
	}

	public void StudentList() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}

	}

	public void StudentA() {
		System.out.println("장학금 대상자");
		for(int i=0; i< list.size(); i++) {
			 String grade =grade(list.get(i).getKor(), list.get(i).getEng(), list.get(i).getMath());
			 if(grade.equals("A")) {
				 System.out.println("학번 : " + list.get(i).getsNum()+ " 이름 : " +list.get(i).getsName());
			 }
			 
		}
	}

	public String grade(int kor, int eng, int math) {
		double avg = (double)((kor + eng + math) / 3);
		if (avg >= 90) {
			result = "A";
		} else if (avg >= 80) {
			result = "B";
		} else if (avg >= 70) {
			result = "C";
		} else if (avg >= 60) {
			result = "D";
		} else {
			result = "F";
		}
			
		return result;
	}
	
	private void readTofile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/temp/Student.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (List<Student>)ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	
	}

	public void storeTofile() {
		
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/Student.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
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
