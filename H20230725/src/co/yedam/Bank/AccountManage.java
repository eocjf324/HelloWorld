package co.yedam.Bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManage {

	List<Bank> list = new ArrayList<>();
	List<Bank> list2 = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	AccountManage() {
		readTofile();
	}

	public void addAccount() {
		System.out.println("계좌생성");
		String account = "";
		int check = -1;

		while (true) {
			int num = (int) (Math.random() * (99999 - 10000 + 1) + 10000); // 5자리 난수로 계좌생성
			account = String.valueOf(num);

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).account.equals(account)) { // 계좌번호가 존재하는지 확인
					check = 1;
				}
			}
			if (check == -1)
				break;
		}

		System.out.print("이름입력>");
		String name = scan.nextLine();
		System.out.print("비밀번호입력>");
		String pw = scan.nextLine();
		System.out.print("입금액>");
		String balance = scan.nextLine();

		if (balance.isEmpty()) {
			list.add(new Bank(account, name, pw));
		} else {
			int balance2 = Integer.parseInt(balance);
			list.add(new Bank(account, name, pw, balance2));
		}
	}

	public void deposit() {
		System.out.println("입금");
		System.out.print("입금할 계좌번호입력>");
		String account = scan.nextLine();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccount().equals(account)) {
				System.out.println("입금액 입력>");
				int balance = Integer.parseInt(scan.nextLine());
				list.get(i).setBalance(list.get(i).getBalance() + balance);
				list2.add(new Bank("+" + balance));
			}
		}
	}

	public void withdraw() {
		System.out.println("출금");
		System.out.print("출금할 계좌번호입력>");
		String account = scan.nextLine();
		System.out.print("비밀번호 입력>");
		String pw = scan.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccount().equals(account) && list.get(i).getPassword().equals(pw)) {
				System.out.println("출금액 입력>");
				int balance = Integer.parseInt(scan.nextLine());
				if (list.get(i).getBalance() >= balance) {
					list.get(i).setBalance(list.get(i).getBalance() - balance);
					list2.add(new Bank("-" + balance));
				} else {
					System.out.println("잔액이 부족함");
					break;
				}
			}

		}
	}

	public void show() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}

	}

	public void dealList() {
		System.out.println("거래내역 조회 : 계좌번호입력>");
		String account = scan.nextLine();
		int total = 0;
		for (int i = 0; i < list2.size(); i++) {
			String s = list2.get(i).getBalance2().substring(0, 1);
			if (!list.isEmpty()) {
				if (s.equals("+")) {
					System.out.println("계좌 :" + list2.get(i).getAccount() + " 입금된 금액 : " + list2.get(i).getBalance2());
					System.out.println(i);
					System.out.println(list2.size());
				} else {
					System.out.println("계좌 :" + list2.get(i).getAccount() + " 출금된 금액 : " + list2.get(i).getBalance2());
					System.out.println(i);
					System.out.println(list2.size());
				}
				total = list.get(i).getBalance();
			}

		}
		System.out.printf("잔고 : %d\n", total);
	}

	public void readTofile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/temp/Bank.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (List<Bank>) ois.readObject();
			System.out.println("계좌 불러오기");
			ois.close();
			fis.close();

		} catch (Exception e) {
//			e.printStackTrace();
		}

	}

	public void storeTofile() {

		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/Bank.db");
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
