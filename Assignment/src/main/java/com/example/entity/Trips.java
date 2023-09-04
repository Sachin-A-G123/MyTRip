package com.example.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="trips")
public class Trips {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private String tid;
	private String name;
	private Integer days;
	private LocalDateTime startingDate; 
	private LocalDateTime endDate;
	private String location;
	
	@CreationTimestamp
    private LocalDateTime createdDate;


    @UpdateTimestamp
    private LocalDateTime updatedDate;
	
	@ManyToMany
	private List<Users> usersEnrolled;
	
  
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public LocalDateTime getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDateTime startingDate) {
		this.startingDate = startingDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Users> getUsersEnrolled() {
		return usersEnrolled;
	}

	public void setUsersEnrolled(List<Users> usersEnrolled) {
		this.usersEnrolled = usersEnrolled;
	}


	 public Trips(String tid, String name, Integer days, LocalDateTime startingDate, LocalDateTime endDate,
				String location, LocalDateTime createdDate, LocalDateTime updatedDate, List<Users> usersEnrolled) {
			super();
			this.tid = tid;
			this.name = name;
			this.days = days;
			this.startingDate = startingDate;
			this.endDate = endDate;
			this.location = location;
			this.createdDate = createdDate;
			this.updatedDate = updatedDate;
			this.usersEnrolled = usersEnrolled;
		}


	public Trips() {
		super();
	}
	

	
	
	

}
