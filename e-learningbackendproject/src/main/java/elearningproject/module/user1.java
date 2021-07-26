package elearningproject.module;

import java.sql.Date;
import java.time.LocalDate;

public class user1 {
	private Long user_id;
	private String name;
	private Double phone_no;
	private String email;
	private String address;
	
	private String reg_date;
	private String password;
	private String upload_photo;
	public user1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user1(Long user_id, String name, Double phone_no, String email, String address, String reg_date,
			String password, String upload_photo) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.phone_no = phone_no;
		this.email = email;
		this.address = address;
		this.reg_date = reg_date;
		this.password = password;
		this.upload_photo = upload_photo;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(Double phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUpload_photo() {
		return upload_photo;
	}
	public void setUpload_photo(String upload_photo) {
		this.upload_photo = upload_photo;
	}
	@Override
	public String toString() {
		return "user1 [user_id=" + user_id + ", name=" + name + ", phone_no=" + phone_no + ", email=" + email
				+ ", address=" + address + ", reg_date=" + reg_date + ", password=" + password + ", upload_photo="
				+ upload_photo + "]";
	}
	

	

	


	
		


	

}
