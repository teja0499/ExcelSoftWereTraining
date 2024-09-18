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

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER = "root";
    private static final String PASS = "root";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String mobile = req.getParameter("mobile");
        String email = req.getParameter("email");
        String qualification = req.getParameter("Qualification");
        String dob = req.getParameter("dob");
        String gender = req.getParameter("gender");
        System.out.println(id);
        System.out.println(name);
        System.out.println(mobile);
        System.out.println(email);
        System.out.println(qualification);
        System.out.println(gender);
        System.out.println("dob "+dob);

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

           
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String query = "UPDATE user_data SET name=?, mobile=?, email=?, qualification=?,dob=?, gender=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, mobile);
            ps.setString(3, email);
            ps.setString(4, qualification);
            ps.setString(5, dob);
            ps.setString(6, gender);
            ps.setInt(7, Integer.parseInt(id));

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully.");
            }

            ps.close();
            conn.close();


            resp.sendRedirect("AllUser.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
