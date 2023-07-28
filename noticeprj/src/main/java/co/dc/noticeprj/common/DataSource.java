package co.dc.noticeprj.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private static DataSource dataSource = new DataSource();

	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection conn;

	private DataSource() {
		try {
			getProperties();
			Class.forName(driver);
			System.out.println("DB 연결성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB 연결실패");
		}
	}

	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private void getProperties() {
		String resource = "/database.properties";
		Properties properties = new Properties();
		try {
			InputStream reader = getClass().getResourceAsStream(resource);
			properties.load(reader);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
