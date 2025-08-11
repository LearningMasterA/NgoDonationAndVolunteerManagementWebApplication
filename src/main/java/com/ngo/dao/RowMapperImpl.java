package com.ngo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.donation.Donor;

public class RowMapperImpl implements RowMapper<Donor>{

	public Donor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Donor d=new Donor();
		d.setId(rs.getInt(1));
		d.setName(rs.getString(2));
		d.setEmail(rs.getString(3));
		d.setPhone(rs.getString(4));
		d.setDonation_type(rs.getString(5));
		d.setAmount_of_items(rs.getString(6));
		d.setDonated_on(rs.getTimestamp(7));
		return d;
	}

}
