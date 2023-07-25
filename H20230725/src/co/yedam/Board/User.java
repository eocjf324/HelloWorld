package co.yedam.Board;

import java.io.Serializable;

public class User implements Serializable{
	String id;
	String name;
	String pw;
	
	
	public User(String id, String name, String pw) {
	
		this.id = id;
		this.name = name;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "ID : " + id + "이름 :" + name ;
	}
	
	
}
