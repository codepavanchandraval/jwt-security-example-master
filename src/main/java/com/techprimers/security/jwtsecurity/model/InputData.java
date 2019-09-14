package com.techprimers.security.jwtsecurity.model;

public class InputData {

	private String ifsc;
	private	String branch;
	private String address;
	private String city;
	private String district;
	private String state;
	private String bankName;
	private Integer limit;
	private Integer offset;

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Integer getLimit() {
	    if(limit==null) {
	    	limit = 10;
	    }
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		if(offset==null) {
			offset = 0;
		}
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
}

