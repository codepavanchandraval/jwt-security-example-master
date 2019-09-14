package com.techprimers.security.jwtsecurity.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.techprimers.security.jwtsecurity.model.BankDetail;

public class BranchRowMapper implements RowMapper<BankDetail> {

	@Override
	public BankDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		BankDetail bankDetails = new BankDetail();
		return bankDetails;
	}
}
