package com.techprimers.security.jwtsecurity.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techprimers.security.jwtsecurity.model.BankDetail;

public class BranchService {
	@Autowired BranchDao branchDao;
	
	public BankDetail find(String ifscCode) {
		BranchDao branchDao =new BranchDao();
		return branchDao.find(ifscCode);
	}

    public 	List<BankDetail> findAll(String bankName,String city,int limit,int offset){
    	BranchDao branchDao =new BranchDao();
    	return branchDao.findAll(bankName,city,limit,offset);
	}
	
}
