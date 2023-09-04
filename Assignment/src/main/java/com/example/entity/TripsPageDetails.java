package com.example.entity;

import java.util.List;

public class TripsPageDetails {
	private int pageNo;
	private long pageSize;
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
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}
	public List<Trips> getData() {
		return data;
	}
	public void setData(List<Trips> data) {
		this.data = data;
	}
	
}
