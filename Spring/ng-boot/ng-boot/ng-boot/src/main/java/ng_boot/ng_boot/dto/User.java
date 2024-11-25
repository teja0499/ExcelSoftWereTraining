package ng_boot.ng_boot.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Ng-Boot_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank(message = "Name cannot be null")
	@Size(min = 2, max = 25, message = "Name must be between 2 and 50 characters")
	private String name;

	@NotNull(message = "Event date cannot be null")
//	@Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Date must be in the format dd-MM-yyyy")
	private String dob;

	@NotNull(message = "Gender cannot be null")
	private String gender;

	@NotBlank(message = "Password cannot be null")
	@Size(min = 1, max = 25, message = "Password must be between 1 and 50 characters")
	private String password;

	@NotNull(message = "Email cannot be null")
	@Email(message = "Invalid email format")
//	@Column(unique = true ) 
	private String email;

	@NotBlank(message = "Mobile number cannot be null")
//	@Pattern(regexp = "^[7-9][0-9]{9}$", message = "Invalid mobile number. Must be a 10-digit number starting with 7-9")
	private String mobile;

	@NotNull(message = "Qualification number cannot be null")
	private String qualification;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", password=" + password
				+ ", email=" + email + ", mobile=" + mobile + ", qualification=" + qualification + "]";
	}

}
