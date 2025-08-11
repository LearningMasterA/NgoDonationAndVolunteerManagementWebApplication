package com.spring.donation;

import java.sql.Timestamp;

public class Donor {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String donation_type;
	private String amount_of_items;
	private Timestamp donated_on;
	@Override
	public String toString() {
		return "Donor [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", donation_type="
				+ donation_type + ", amount_of_items=" + amount_of_items + ", donated_on=" + donated_on + "]";
	}
	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Donor(int id, String name, String email, String phone, String donation_type, String amount_of_items,
			Timestamp donated_on) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.donation_type = donation_type;
		this.amount_of_items = amount_of_items;
		this.donated_on = donated_on;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDonation_type() {
		return donation_type;
	}
	public void setDonation_type(String donation_type) {
		this.donation_type = donation_type;
	}
	public String getAmount_of_items() {
		return amount_of_items;
	}
	public void setAmount_of_items(String amount_of_items) {
		this.amount_of_items = amount_of_items;
	}
	public Timestamp getDonated_on() {
		return donated_on;
	}
	public void setDonated_on(Timestamp l) {
		this.donated_on = l;
	}

}
