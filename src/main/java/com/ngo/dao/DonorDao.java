package com.ngo.dao;

import java.util.List;

import com.spring.donation.Donor;

public interface DonorDao {
	public int insertDonor(Donor d);

	public List<Donor> getAllDonors();

	public Donor getDonorById(int id);

	public boolean updateDonor(int id,String field,String newValue);
	

}
