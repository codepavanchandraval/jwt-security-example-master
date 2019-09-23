package com.techprimers.security.jwtsecurity.Dao;

import java.util.List;

import org.springframework.core.env.Environment;

import com.techprimers.security.jwtsecurity.model.BankDetail;

public class BranchService {
	private Environment environment;
	
	public BranchService(Environment environment) {
	this.environment = environment;
	doOneTimeDBSetup();
	}
	
	private void doOneTimeDBSetup() {
		if (DbConnectionProvider.getConnection() == null) {
			try {
				DbConnectionProvider.createConnection(environment.getProperty("spring.datasource.url"),
						environment.getProperty("spring.datasource.username"),
						environment.getProperty("spring.datasource.password"));
			} catch (Exception e) {
				System.out.println("Error while accessing Environment");
			}
		}
	}

	public BankDetail find(String ifscCode) {
		BranchDao branchDao =new BranchDao();
		return branchDao.find(ifscCode);
	}

    public 	List<BankDetail> findAll(String bankName,String city,int limit,int offset){
    	BranchDao branchDao =new BranchDao();
    	return branchDao.findAll(bankName,city,limit,offset);
	}
	
}
