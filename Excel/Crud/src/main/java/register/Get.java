package register;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Get {
	private List<User> users;

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getAll() {
		if (users == null) {
			users = new ArrayList<>();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("get all users");
		String query = "SELECT * FROM user_data";
		try {
			DBC dbConnection = new DBC();
			pstmt = dbConnection.connection().prepareStatement(query);
			rs = pstmt.executeQuery();
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
		} catch (Exception e) {
			System.out.println("Error retrieving users: " + e.getMessage());
		}

		return users;
	}
}
