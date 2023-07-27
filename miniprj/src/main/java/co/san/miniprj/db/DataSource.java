package co.san.miniprj.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource { // 싱글톤 패턴

	private static DataSource dataSource; // 싱글톤 방식

	private String driver;
	private String url ;
	private String user;
	private String password;
	public static Connection conn;

//	private DataSource() { // private 외부에서 생성자 생성x
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("DB 연결 성공 !!!!");
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println("DB 연결 실패!!");
//		}
//	}
	private DataSource() { // private 외부에서 생성자 생성x
		try {
			getProperty();
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("DB 연결 실패!!");
		}
	}
	
	private void getProperty() { // db.properties 파일에서 정보를 가져온다.
		String resource = "/config/db.properties";
		Properties properties = new Properties();
		
		try {
			InputStream reader = getClass().getResourceAsStream(resource);
			properties.load(reader);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static DataSource getInstance() { //
		DataSource dataSource = new DataSource();
		return dataSource;
	}

	public Connection getConnection() {
	
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공!!");
		} catch (SQLException e) {

		}
		return conn;
	}
}
