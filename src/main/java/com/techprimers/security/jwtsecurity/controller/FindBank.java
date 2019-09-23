package com.techprimers.security.jwtsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techprimers.security.jwtsecurity.Dao.BranchService;
import com.techprimers.security.jwtsecurity.model.BankDetail;

@Controller
public class FindBank {
	@Autowired
	private Environment environment; 
	
	@GetMapping("/rest/findBank")
	@ResponseBody
	public BankDetail getBankData(@RequestParam final String ifscCode) {
		BranchService branchService = new BranchService(environment);
        if(ifscCode==null) {
        	return null;
        }
        return branchService.find(ifscCode);
    }
	
	@GetMapping("/rest/findAllBank")
	@ResponseBody
	public List<BankDetail> getAllBankData(@RequestParam final String bankName,@RequestParam final String city,@RequestParam final int limit,@RequestParam final int offset) {
		BranchService branchService = new BranchService(environment);
		 if(bankName==null||city==null) {
        	return null;
        }
        return branchService.findAll(bankName, city,limit,offset);
    }
}
