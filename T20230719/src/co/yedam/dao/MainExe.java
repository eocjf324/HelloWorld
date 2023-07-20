package co.yedam.dao;

public class MainExe {
	public static void main(String[] args) {
		//MysqlDao dao = new MysqlDao();
		//OracleDao dao = new OracleDao();
		
		Dao dao = new OracleDao();
		
		
		dao.insert();

		dao.modify();

		dao.search();

		dao.remove();
	}
}
