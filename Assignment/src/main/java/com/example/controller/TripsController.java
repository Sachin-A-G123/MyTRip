package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Trips;
import com.example.entity.TripsPageDetails;
import com.example.entity.TripsPageDetailsByUserId;
import com.example.entity.UsersPageDetails;
import com.example.repository.TripsRepository;
import com.example.service.TripsService;

@RestController
@RequestMapping("/trips")
public class TripsController {
	
	@Autowired
	private TripsService tripService;
	
	@Autowired
	TripsRepository tripRepo;
	
	
//	@GetMapping
//	public ResponseEntity<List<Trips>> getAllTrips(){
//		return tripService.getAllUsers();
//	}
	
	    @GetMapping
	    public  ResponseEntity<TripsPageDetails>  findall(@RequestParam(value="pageNo",defaultValue = "0",required=false)int pageno,

	                            @RequestParam(value="pageSize",defaultValue = "1",required=false)int pageSize,

	                            @RequestParam(value="sortBy",defaultValue = "name",required=false) String sortBy,

	                               @RequestParam(value="sortDir",defaultValue ="asc",required=false) String sortDir){


		   TripsPageDetails allUser = tripService.findall(pageno,pageSize,sortBy,sortDir);

	  return new ResponseEntity<>(allUser,HttpStatus.OK);

	}
//		@GetMapping("/tripDetailById/{uid}")
//	    public ResponseEntity<List<Trips>> getAllTripsByUid(@PathVariable String uid) {
//	        List<Trips> trips = tripService.getAllTripsByUid(uid);
//	        return ResponseEntity.ok(trips);
//	    }		
		
	
	@GetMapping("/{tid}")
	public ResponseEntity<Trips> getTripById(@PathVariable String tid) {
		Optional<Trips> trip = tripService.getTripById(tid);
        if (trip.isPresent()) {
            return ResponseEntity.ok(trip.get()); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
	       
	}
	
    @GetMapping("/tripDetailById/{uid}")
    public ResponseEntity<TripsPageDetailsByUserId> getAllTripsByUid(
    		@PathVariable("uid") String uid,
			@RequestParam(value="pageNo",defaultValue="0",required=false)int pageNo,
			@RequestParam(value="pageSize",defaultValue="1",required=false)int pageSize
			){
    	TripsPageDetailsByUserId allPost=tripService.getAllTripsByUid(pageNo, pageSize,uid);
		return new ResponseEntity<TripsPageDetailsByUserId>(allPost,HttpStatus.OK);
	}
		
	
	@PostMapping
	public ResponseEntity<Trips> addTrip(@RequestBody Trips trip){
		return tripService.addTrip(trip);
	}
	
	
	
	@PutMapping("/{tid}")
	public ResponseEntity<Trips> updateTrip(@PathVariable String tid, @RequestBody Trips updatedTrip) {
	    // Update the trip in the database
	    return tripService.updateTrip(tid, updatedTrip);
	
	}
	
//	@PutMapping("/adduser/{tid}")
//	public ResponseEntity<Trips> addUsersToTrip(@PathVariable String tid, @RequestBody List<String> uid) {
//	    Trips updatedTrip = tripService.addUsersToTrip(tid, uid);
//	    if (updatedTrip != null) {
//	        return ResponseEntity.ok(updatedTrip);
//	    }
//	    return ResponseEntity.notFound().build();
//	}
//	
	@PutMapping("/trips/{tid}/addUser/{uid}")
	public ResponseEntity<Trips> addUserToTrip(@PathVariable String tid, @PathVariable String uid) {
	    // Add user to the trip in the database
	    Trips updatedTrip = tripService.addUserToTrip(tid, uid);
        if (updatedTrip != null) {
            return ResponseEntity.ok(updatedTrip); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
	}
	
	
	@DeleteMapping("/{tid}")
	public ResponseEntity<String> deleteTrip(@PathVariable String tid){
		return tripService.deleteTrip(tid);
	}


	
}
