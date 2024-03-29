package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Trips;

@Repository
public interface TripsRepository extends JpaRepository<Trips,String> {
	 Page<Trips> findByUsersEnrolledUid(String uid, Pageable pageable);
}
