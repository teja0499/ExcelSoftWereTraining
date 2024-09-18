package User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/editUser")
public class EditUser extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER = "root";
    private static final String PASS = "root";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String query = "SELECT * FROM user_data WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getString("qualification"));
                req.setAttribute("id", rs.getInt("id"));
                req.setAttribute("name", rs.getString("name"));
                req.setAttribute("mobile", rs.getString("mobile"));
                req.setAttribute("email", rs.getString("email"));
                req.setAttribute("qualification", rs.getString("qualification"));
                req.setAttribute("dob", rs.getString("dob"));
                req.setAttribute("gender", rs.getString("gender"));
            }

            rs.close();
            ps.close();
            conn.close();

            RequestDispatcher rd = req.getRequestDispatcher("EditUser.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
