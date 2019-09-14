package com.techprimers.security.jwtsecurity.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techprimers.security.jwtsecurity.Dao.BranchService;
import com.techprimers.security.jwtsecurity.model.BankDetail;
import com.techprimers.security.jwtsecurity.model.InputData;

@Controller
public class FindBank {
	
	
	@GetMapping("/rest/findBank")
	@ResponseBody
	public BankDetail getBankData(@RequestBody final InputData inputData) {
		BranchService branchService = new BranchService();
		String ifscCode = inputData.getIfsc();
        if(ifscCode==null) {
        	return null;
        }
        return branchService.find(ifscCode);
    }
	
	@GetMapping("/rest/findAllBank")
	@ResponseBody
	public List<BankDetail> getAllBankData(@RequestBody final InputData inputData) {
		BranchService branchService = new BranchService();
		String bankName  = inputData.getBankName();
		String city = inputData.getCity();
        if(bankName==null||city==null) {
        	return null;
        }
        int limit = inputData.getLimit();
        int offset = inputData.getOffset();
        return branchService.findAll(bankName, city,limit,offset);
    }
	
	

}
