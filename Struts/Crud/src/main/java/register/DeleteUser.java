package register;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DeleteUser {
private int id;
private List<User> users;
public List<User> getUsers() {
	Get get=new Get();
	return get.getAll();
}

public void setUsers(List<User> users) {
    this.users = users;
}


public int getId() {
	System.out.println("get id"+ id);
	return id;
}

public void setId(int id) {
	System.out.println("set id "+id);
	this.id = id;
}

public String deleteUser()
{
	System.out.println("ok delete "+id);

	PreparedStatement pstmt = null;
   
    String query = "DELETE FROM user_data WHERE id = ?";
    try  {
    	DBC dbConnection=new DBC();
		pstmt = dbConnection.connection().prepareStatement(query);
        pstmt.setInt(1, id);
        int rowDeleted = pstmt.executeUpdate();
        if (rowDeleted > 0) {
            System.out.println("User deleted successfully.");
            return "success";
        }else
        {
        	 System.out.println("Login failed. Invalid email or password.");
             return "unsuccess";
        }
          
    } catch (Exception e) {
        System.out.println("Error during login: " + e.getMessage());
        return "unsuccess";
    }
}

}
