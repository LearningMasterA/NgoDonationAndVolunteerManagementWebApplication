package com.ngo.dao;

import com.spring.donation.Donor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ngo.dao.DonorDao;
@Component("donorDao")
public class DonorDaoImpl implements DonorDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int insertDonor(Donor d) {
		String q="insert into donors(name,email,phone,donation_type,amount_of_items) values (?,?,?,?,?)";
		int i = jdbcTemplate.update(q,d.getName(),d.getEmail(),d.getPhone(),d.getDonation_type(),d.getAmount_of_items());
		
	    return i;
	}
	public List<Donor> getAllDonors() {
		RowMapper<Donor> rowMapper=new RowMapperImpl();
		String q="select * from donors";
		List<Donor> li=jdbcTemplate.query(q, rowMapper);
		return li;
	}
	public Donor getDonorById(int id) {
		String q="select * from donors where id=?";
		RowMapper<Donor> rowMapper=new RowMapperImpl();
		Donor d=this.jdbcTemplate.queryForObject(q,rowMapper,id);
		return d;
	}
	public boolean updateDonor(int id, String field, String newValue) {
		Donor d=new Donor();
		boolean f=false;
		String q="update donors set "+ field+"=? where id=?";
		try {
		 int i=jdbcTemplate.update(q,newValue,id);
		f=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}

}
