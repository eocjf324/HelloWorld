package co.yedam.friend;

public class Company extends Friend{
	String company;
	String dept;
	
	public Company(String name, String phone, String com, String dept) {
		super(name, phone);
		this.company = com;
		this.dept = dept;
	}

	@Override
	public String showInfo() {
		return "이름: " + getName() + ", 연락처: " + getPhone()  + ", 회사: " + company + ", 전공: " + dept;
	}


}
