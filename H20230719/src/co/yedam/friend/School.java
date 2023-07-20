package co.yedam.friend;

public class School extends Friend{

	String school;
	String major;
	
	public School(String name, String phone, String shool, String major) {
		super(name, phone);
		this.school = shool;
		this.major = major;
	}
	
	@Override
	public String showInfo() {
		return "이름: " + getName() + ", 연락처: " + getPhone()  + ", 학교: " + school + ", 전공: " + major;
	}

	
}
