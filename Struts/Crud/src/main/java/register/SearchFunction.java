package register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SearchFunction {

    private String name;
    private List<User> users = new ArrayList<>(); 

    public List<User> getUsers() {
    	System.out.println(users);
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String search() {
    	System.out.println(" SearchFunction start");
        String query = "SELECT * FROM user_data WHERE name like ?";
        try (Connection connection = new DBC().connection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, "%"+ name+"%");
            System.out.println(name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setDob(rs.getString("dob"));
                user.setGender(rs.getString("gender"));
                user.setMobile(rs.getString("mobile"));
                user.setQualification(rs.getString("qualification"));
                users.add(user);
            }
            
            System.out.println(" SearchFunction end");
            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // Indicate failure
        }
    }
}
