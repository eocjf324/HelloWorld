package co.yedam.dao;

public class MysqlDao implements Dao{
	// add(), modify(), del(), find()

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Mysql 등록.");
	}

	public void modify() {
		System.out.println("Mysql 수정.");
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		System.out.println("Mysql 삭제.");
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		System.out.println("Mysql 조회.");
	}
}
