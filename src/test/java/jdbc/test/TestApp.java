package jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.a.dao.UserDao;
import com.a.domain.User;

import jdbc.JDBC_Utils;

public class TestApp {
	@Test
	public void test02() throws Exception {
		UserDao  u = new UserDao();
		User u1 = new User();
		u1.setUsername("tom");
		u1.setPassword("1256");
		boolean query = u.query(u1);
		System.out.println(query);
		
	}
	
	
	@Test
	public void test01() throws SQLException{
		Connection conn = JDBC_Utils.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from emp");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1)+",");
			System.out.println(rs.getString(2));
		}

	}
	
}
