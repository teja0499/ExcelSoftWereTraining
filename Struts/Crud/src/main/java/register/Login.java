package register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Login {
    private String email;
    private String password;
    private List<User> users;

    // Getters and Setters
    public String getEmail() {
        System.out.println("getEmail called");
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        System.out.println("setEmail called");
    }

    public String getPassword() {
        System.out.println("getPassword called");
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        System.out.println("setPassword called");
    }

    public List<User> getUsers() {
    	Get get=new Get();
    	return get.getAll();
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String login() {
    	PreparedStatement pstmt = null;
        System.out.println("Login attempt: " + email + " " + password);
        String query = "SELECT * FROM user_data WHERE email = ? AND password = ?";
        try  {
        	DBC dbConnection=new DBC();
			pstmt = dbConnection.connection().prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Login successful for user: " + rs.getString("name"));
                    return "success";
                } else {
                    System.out.println("Login failed. Invalid email or password.");
                    return "unsuccess";
                }
            }
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
            return "unsuccess";
        }
    }
}
