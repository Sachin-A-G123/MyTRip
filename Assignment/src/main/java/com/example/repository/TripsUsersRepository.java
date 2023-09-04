package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.entity.TripsUsersEnrolled;

@Repository
public interface TripsUsersRepository  extends JpaRepository<TripsUsersEnrolled,Integer>{

}
