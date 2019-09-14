package com.techprimers.security.jwtsecurity.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.techprimers.security.jwtsecurity.model.BankDetail;

public class BranchDao {

	public BankDetail find(String ifscCode) {
		BankDetail bankDetails = null;
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/main", "postgres",
				"system")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from banks b,branches br where b.id=br.bank_id and br.ifsc = '"+ifscCode+"'");
			if (resultSet.next()) {
				bankDetails = new BankDetail();
				bankDetails.setAddress(resultSet.getString("address"));
				bankDetails.setBankName(resultSet.getString("name"));
				bankDetails.setIfsc(resultSet.getString("ifsc"));
				bankDetails.setCity(resultSet.getString("city"));
				bankDetails.setDistrict(resultSet.getString("district"));
				bankDetails.setState(resultSet.getString("state"));
				bankDetails.setBranch(resultSet.getString("branch"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankDetails;
	}

	public List<BankDetail> findAll(String bankName, String city, int limit,int offset) {
		List<BankDetail> bankDetails = null;
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/main", "postgres",
				"system")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from banks b,branches br where b.id=br.bank_id and b.name='"+bankName+"' and br.city='"+city+"' limit "+limit+" offset "+offset+"");
			bankDetails = new ArrayList<>();
			while (resultSet.next()) {
				BankDetail bankDetail = new BankDetail();
				bankDetail.setAddress(resultSet.getString("address"));
				bankDetail.setBankName(resultSet.getString("name"));
				bankDetail.setIfsc(resultSet.getString("ifsc"));
				bankDetail.setCity(resultSet.getString("city"));
				bankDetail.setDistrict(resultSet.getString("district"));
				bankDetail.setState(resultSet.getString("state"));
				bankDetail.setBranch(resultSet.getString("branch"));
				bankDetails.add(bankDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankDetails;
	}

}
