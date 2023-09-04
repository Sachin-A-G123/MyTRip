package com.example.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.Trips;
import com.example.entity.TripsPageDetails;
import com.example.entity.TripsPageDetailsByUserId;
import com.example.entity.UsersPageDetails;
import com.example.entity.Users;
import com.example.repository.TripsRepository;
import com.example.repository.TripsUsersRepository;
import com.example.repository.UsersRepository;

@Service
public class TripsService {
	
	@Autowired
	TripsRepository tripRepo;
	
//	@Autowired
//	TripsUsersRepository tripsuserRepo;
	
	@Autowired
	UsersService userService;

//	public ResponseEntity<List<Trips>> getAllUsers() {
//		
//		return new ResponseEntity<>(tripRepo.findAll(),HttpStatus.OK);
//	}
	
    public TripsPageDetails findall(int pageNo,int pageSize,String sortBy,String SortDir){

        Sort sortDirection= SortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

        Pageable p=PageRequest.of(pageNo, pageSize,sortDirection);

        Page<Trips> page = tripRepo.findAll(p);	

        List<Trips> content = page.getContent();
  
        TripsPageDetails upd= new TripsPageDetails();
       
        upd.setData(content);

        upd.setPageNo(page.getNumber());

        upd.setTotalData(page.getNumberOfElements());

        upd.setPageSize(page.getSize());
       
         return upd;
    }

	public Optional<Trips> getTripById(String tid) {
		return tripRepo.findById(tid);
	}
	
//	public List<Trips> getAllTripsByUid(String  uid) {
//        return tripRepo.findByUsersEnrolledUid(uid);
//    }
	
	
    public TripsPageDetailsByUserId getAllTripsByUid(int pageNo,int pageSize,String uid) {
		
		Pageable p=PageRequest.of(pageNo, pageSize);
		
//		return new ResponseEntity<>(userRepo.findAll(),HttpStatus.OK);
		Page<Trips> pagePost=tripRepo.findByUsersEnrolledUid(uid, p);
		List<Trips> allPostss=pagePost.getContent();
		TripsPageDetailsByUserId upd= new TripsPageDetailsByUserId();
//      
       upd.setData(allPostss);

       upd.setPageNo(pagePost.getNumber());

       upd.setTotalData(pagePost.getNumberOfElements());

       upd.setPageSize(pagePost.getSize());
      
       return upd; 
    }
    
	public ResponseEntity<Trips> addTrip(Trips trip) {
		    tripRepo.save(trip); 
//		    return ResponseEntity.status(HttpStatus.CREATED).body(createdTrip);
		 return ResponseEntity.status(HttpStatus.CREATED).body(trip);
	}

	public ResponseEntity<Trips> updateTrip(String tid, Trips updatedTrip) {
		Trips existingTrip = tripRepo.findById(tid).orElse(null);

        if (existingTrip != null) {
            existingTrip.setName(updatedTrip.getName());
            existingTrip.setDays(updatedTrip.getDays());
            existingTrip.setStartingDate(updatedTrip.getStartingDate());
            existingTrip.setEndDate(updatedTrip.getEndDate());
            existingTrip.setLocation(updatedTrip.getLocation());
            existingTrip.setUpdatedDate(LocalDateTime.now());
            
//            return tripRepo.save(existingTrip);
//        }
//        return null; 
            Trips updated = tripRepo.save(existingTrip);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	
//	 public Trips addUsersToTrip(String tid, List<String> uid) {  main
//	        Trips trip = tripRepo.findById(tid).orElse(null);
//
//	        if (trip != null) {
//	            List<Users> users = new ArrayList<>();
//	            for (String userId : uid) {
//	                Optional<Users> user = userService.getUserById(userId);
//	                if (user != null) {
//	                    users.add(user.get());
//	                }
//	            }
//	            trip.getUsersEnrolled().addAll(users);
//	            return tripRepo.save(trip);
//	        }
//	        return null;  
//	    }
	
	public Trips addUserToTrip(String tid, String uid) {
        Trips trips = tripRepo.findById(tid).orElse(null);
        if (trips != null) {
            Optional<Users> userOptional = userService.getUserById(uid);
            if (userOptional.isPresent()) {
                Users user = userOptional.get();
                trips.getUsersEnrolled().add(user);
                return tripRepo.save(trips);
            }
        }
        return null; // Trip or user not found
	}
	
//	public Trips addUserToTrip(String tid, String uid) {
//        Trips trip = tripRepo.findById(tid).orElse(null);
//
//        if (trip != null) {
//        	List<Users> users = new ArrayList<>();
//                Optional<Users> user = userService.getUserById(uid);
//                if (user != null) {
//                    users.add(user.get());
//                }
//      
//            trip.getUsersEnrolled().addAll(users);
//            return tripRepo.save(trip);
//        }
//        return null;  
//    }
	
//	public Trips addUserToTrip(String tid, String uid) {
//        Trips trip = tripRepo.findById(tid).orElse(null);
//        Optional<Users> user = userService.getUserById(uid);
//
//        if (trip != null && user != null) {
//            trip.getUsersEnrolled().addAll(user);
//            return tripRepo.save(trip);
//        }
//        return null; // Trip or User not found
//    }
	
	public ResponseEntity<String> deleteTrip(String tid) {
		   tripRepo.deleteById(tid);
		   return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
	}


}
