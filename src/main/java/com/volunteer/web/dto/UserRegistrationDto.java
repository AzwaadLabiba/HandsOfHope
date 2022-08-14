package com.volunteer.web.dto;

public class UserRegistrationDto {
	
	private String f_name;
	private String l_name;
	private String email;
	
	
	public UserRegistrationDto(String f_name, String l_name, String email, String contact, String password,
			String city) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.city = city;
	}
	public UserRegistrationDto() {
		
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	private String contact;
	private String password;
	private String city;

}
