package com.example.entity;

import java.util.List;

public class TripsPageDetailsByUserId {
	
	private int pageNo;
	private int pageSize;
	private int totalData;
	private List<Trips> data;
	
	
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
	public List<Trips> getData() {
		return data;
	}
	public void setData(List<Trips> data) {
		this.data = data;
	}
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}

}
