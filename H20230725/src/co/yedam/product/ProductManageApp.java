package co.yedam.product;

import java.util.Scanner;

public class ProductManageApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ProductManage pm = new ProductManage();
		boolean run = true;
		System.out.println("제품관리프로그램");
		while (run) {
			System.out.println("1.상품등록 2.판매관리 3.구매관리 4.현재재고 5.종료");   //1.  상품코드 상품 이름  가격 
			System.out.print("번호 입력>");									//2.  판매관리 
			int menu = Integer.parseInt(scan.nextLine());

			if (menu == 1) {
				pm.addProduct();
			} else if (menu == 2) {
				pm.sellManage();
			} else if (menu == 3) {
				pm.buyManage();
			} else if (menu == 4) {
				pm.list();
			} else if (menu == 5) {
				pm.stroeTofile();
				pm.stroeTofile2();
				run = false;
			}

		}
	}
}
