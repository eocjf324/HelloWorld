package co.yedam.grade;

import java.io.Serializable;

public class Student implements Serializable {
	int sNum;
	String sName;
	int kor;
	int eng;
	int math;
	
	
	public Student(int sNum, String sName, int kor, int eng, int math) {
		super();
		this.sNum = sNum;
		this.sName = sName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}


	@Override
	public String toString() {
		return "학번 : " + sNum + " 이름 : " + sName + " 국어 : " + kor + " 영어 : " + eng + " 수학 : " + math + " 평균 : " + (kor+eng+math)/3;
	}


	public int getsNum() {
		return sNum;
	}


	public void setsNum(int sNum) {
		this.sNum = sNum;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}
	
}
