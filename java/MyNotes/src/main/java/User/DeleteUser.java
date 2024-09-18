package User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER = "root";
    private static final String PASS = "root";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // SQL Query to delete a user by id
            String query = "DELETE FROM user_data WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));

            int rowDeleted = ps.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("User deleted successfully.");
            }

            ps.close();
            conn.close();

            resp.sendRedirect("AllUser.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

