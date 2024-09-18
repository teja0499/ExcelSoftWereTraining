package User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signUpForm")
public class Register extends HttpServlet {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
	private static final String USER = "root";
	private static final String PASS = "root";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		System.out.println("signUpForm");
		String name = req.getParameter("name");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String dob = req.getParameter("DOB");
		String qualification = req.getParameter("Qualification");
		String gender = req.getParameter("gender");

		if (name == null || mobile == null || email == null || password == null || dob == null || qualification == null || gender == null) {
//			out.print("<h1>Please fill out all fields.</h1>");
			System.out.println("Hellow");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, resp);
			return;
		}
		for(int i=0;i<100;i++)
		{
			int count = registerUser(name, mobile, email, password, dob, qualification, gender);

			if (count > 0) {
				out.print("<h1>Registration successful!</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
				rd.include(req, resp);
			} else {
				out.print("<h1>Registration failed. Please try again.</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
			}
		}
	}

	private int registerUser(String name, String mobile, String email, String password, String dob, String qualification, String gender) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			String sql = "INSERT INTO user_data (name, mobile, email, password, dob, qualification, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, mobile);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setString(5, dob);
			pstmt.setString(6, qualification);
			pstmt.setString(7, gender);

			count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
