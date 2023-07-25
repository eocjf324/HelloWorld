package co.yedam.product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
	Scanner scan = new Scanner(System.in);
	List<Product> products = new ArrayList<>();
	List<Manage> manage = new ArrayList<>();
	int check = 1;

	ProductManage() {
		readFromFile();
		readFromFile2();
	}

	public void addProduct() {
		int code = getCode();
		System.out.print("상품명입력>");
		String name = scan.nextLine();
		System.out.print("상품가격입력>");
		int price = Integer.parseInt(scan.nextLine());
		System.out.print("재고입력>");
		int stack = Integer.parseInt(scan.nextLine());

		products.add(new Product(code, name, price, stack));

	}

	private int getCode() {
		int no = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getCode() > no) {
				no = products.get(i).getCode();
			}
		}
		return no + 1;
	}

	public void sellManage() {

		System.out.print("상품코드입력>");
		int code = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getCode() == code) {
				System.out.print("판매수량입력>");
				int sellcount = Integer.parseInt(scan.nextLine());
				System.out.print("판매일>");
				String selldate = scan.nextLine();
				if (products.get(i).getStack() >= sellcount) {
					products.get(i).setStack(products.get(i).getStack() - sellcount);
					manage.add(new Manage(code, products.get(i).getStack() - sellcount, "판매일:" +selldate));
					check = -1;
					break;
				} else {
					System.out.println("재고가 부족합니다.");
				}
			}
		}
		if (check == 1) {
			System.out.println("없는 상품코드입니다.");
		}
	}

	public void buyManage() {
		System.out.print("상품코드입력>");
		int code = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getCode() == code) {
				System.out.print("구매수량입력>");
				int buycount = Integer.parseInt(scan.nextLine());
				System.out.print("구매일>");
				String buydate = scan.nextLine();

				products.get(i).setStack(products.get(i).getStack() + buycount);
				manage.add(new Manage(code, products.get(i).getStack() - buycount, "구매일:"+ buydate));
			}
		}
	}

	public void list() {
		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i).toString());	
		}
		for (int i = 0; i < manage.size(); i++) {
			System.out.println(manage.get(i).toString());	
		}
	}

	private void readFromFile() {

		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/temp/product.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			products = (List<Product>) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("저장된 정보를 불러옵니다.");
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	private void readFromFile2() {

		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/temp/manage.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			manage = (List<Manage>) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("저장된 정보를 불러옵니다.");
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	public void stroeTofile() {

		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/product.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(products);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void stroeTofile2() {

		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/manage.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(manage);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
