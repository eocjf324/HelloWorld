package co.yedam.product;

import java.io.Serializable;

public class Manage implements Serializable {
	
	int code;
	int sellCount;
	int buyCount;
	String sellDate;
	String buyDate;
	
	
	public Manage(int code, int sellCount, String sellDate) {
		super();
		this.code = code;
		this.sellCount = sellCount;
		this.sellDate = sellDate;
	}
	
	



	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getSellCount() {
		return sellCount;
	}
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}



	@Override
	public String toString() {
		return sellDate + buyDate ;
	}
	

}
