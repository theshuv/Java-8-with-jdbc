package pojo;

import java.sql.Date;

public class Vendors {
	private int id;
	private String name,email,city,phone;
	private Date reg_date;
	public Vendors(int id, String name, String email, String city, String phone, Date reg_date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
		this.phone = phone;
		this.reg_date = reg_date;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "Vendors [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", phone=" + phone
				+ ", reg_date=" + reg_date + "]";
	}
	

}
