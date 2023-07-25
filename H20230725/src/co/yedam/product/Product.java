package co.yedam.product;

import java.io.Serializable;

public class Product implements Serializable {
	
	int code;
	String name;
	int price;
	int stack;
	
	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getStack() {
		return stack;
	}


	public void setStack(int stack) {
		this.stack = stack;
	}


	public Product(int code, String name, int price, int stack) {

		this.code = code;
		this.name = name;
		this.price = price;
		this.stack = stack;
	}


	@Override
	public String toString() {
		return "상품코드 :" + code + " 상품명 : " + name + " 가격 : " + price + " 재고 : " + stack;
	}

	

}
