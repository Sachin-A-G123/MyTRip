package com.example.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trips_users_enrolled")
public class TripsUsersEnrolled {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer  id;
    
	@Column(name = "trips_tid")
	private String tripsTid;
	@Column(name = "users_enrolled_uid")
	private String usersEnrolledUid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTripsTid() {
		return tripsTid;
	}
	public void setTripsTid(String tripsTid) {
		this.tripsTid = tripsTid;
	}
	public String getUsersEnrolledUid() {
		return usersEnrolledUid;
	}
	public void setUsersEnrolledUid(String usersEnrolledUid) {
		this.usersEnrolledUid = usersEnrolledUid;
	}



}
