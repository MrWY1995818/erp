package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_Utils {
	private static String username;
	private static String password;
	private static String url;
	private static String driver;
	
	static{
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("jdbc.properties"));
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		url = prop.getProperty("url");
		driver = prop.getProperty("driver");
		Class.forName(driver);
		} catch (Exception e) {
			try {
				throw new Exception("数据库初始化异常");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
	
	public static void closeAll(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
}
