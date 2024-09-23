package register;

import java.sql.PreparedStatement;

public class Register {

	private String name;
	private String dob;
	private String gender;
	private String password;
	private String email;
	private String mobile;
	private String qualification;

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		System.out.println(" set name " + name);
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String register() throws Exception {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO user_data (name, mobile, email, password, dob, qualification, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			DBC dbConnection=new DBC();
			pstmt = dbConnection.connection().prepareStatement(query);
			System.out.println(3);
			pstmt.setString(1, name);
			pstmt.setString(2, mobile);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setString(5, dob);
			pstmt.setString(6, qualification);
			pstmt.setString(7, gender);
			pstmt.executeUpdate();
			System.out.println("done");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return "success";
	}

}
