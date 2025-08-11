package com.spring.donation;

public class Volunteer {
	private int vid;
	private String name;
	private String email;
	private String phone;
	private String skills;
	private String availability;
	
	
	@Override
	public String toString() {
		return "Volunteer [vid=" + vid + ", name=" + name + ", email=" + email + ", phone=" + phone + ", skills="
				+ skills + ", availability=" + availability + "]";
	}
	public Volunteer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Volunteer(int vid, String name, String email, String phone, String skills, String availability) {
		super();
		this.vid = vid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.skills = skills;
		this.availability = availability;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
