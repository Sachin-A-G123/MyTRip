package com.example.entity;

import java.util.List;

public class UsersPageDetails {
	private int pageNo;
	private int pageSize;
	private int totalData;
	private List<Users> data;
	
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Users> getData() {
		return data;
	}
	public void setData(List<Users> data) {
		this.data = data;
	}
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}

}
