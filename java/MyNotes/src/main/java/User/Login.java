package User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class Login extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER = "root";
    private static final String PASS = "root";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        // Log for debugging purposes
        System.out.println("Submitted Email: " + email + " Password: " + password);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        System.out.println("Do post");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM user_data WHERE email = ? AND password = ?";
        System.out.println("Login");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();

            HttpSession session=req.getSession();
            if (rs.next()) {
                System.out.println("Login successful for user: " + rs.getString("name"));
                session.setAttribute("secion_name", rs.getString("name")); 
                RequestDispatcher rd = req.getRequestDispatcher("/AllUser.jsp");
              rd.include(req, resp);
                
            } else {
                System.out.println("Login failed. Invalid email or password.");
//                session.setAttribute("secion_name", rs.getString("name")); 
                RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
              rd.include(req, resp);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
           
        } finally {
            // Close resources to avoid memory leaks
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
//        boolean isValidUser = login(email, password);
//        
//        if (isValidUser) {
//            out.println("<h2>Login successful</h2>");
//            RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
//            rd.include(req, resp);
//        } else {
//            out.println("<h2>Login failed. Invalid email or password.</h2>");
//            RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
//            rd.include(req, resp);
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward the request to the login form (JSP page)
        RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
        rd.forward(req, resp);
    }

    // Method to check login credentials
    public boolean login(String email, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM user_data WHERE email = ? AND password = ?";
        System.out.println("Login");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful for user: " + rs.getString("name"));
                return true; // User found, login successful
            } else {
                System.out.println("Login failed. Invalid email or password.");
                return false; // No matching user found
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            // Close resources to avoid memory leaks
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
