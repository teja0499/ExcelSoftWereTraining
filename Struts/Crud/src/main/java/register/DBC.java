package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBC {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
	private static final String USER = "root";
	private static final String PASS = "root";

	public Connection connection() throws Exception {
		try {
			System.out.println(1);
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(2);
			return  DriverManager.getConnection(DB_URL, USER, PASS);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
}
