package com.example.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.Users;
import com.example.entity.UsersPageDetails;
import com.example.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository userRepo;

//	public ResponseEntity<List<Users>> getAllUsers() {
//		
//		return new ResponseEntity<>(userRepo.findAll(),HttpStatus.OK);
//	}
	
	
	public UsersPageDetails getAllUsers(int pageNo,int pageSize) {
		
		Pageable p=PageRequest.of(pageNo, pageSize);
		
//		return new ResponseEntity<>(userRepo.findAll(),HttpStatus.OK);
		Page<Users> pagePost=this.userRepo.findAll(p); 
		List<Users> allPosts=pagePost.getContent();

		UsersPageDetails upd= new UsersPageDetails();
//      
       upd.setData(allPosts);

       upd.setPageNo(pagePost.getNumber());

       upd.setTotalData(pagePost.getNumberOfElements());

       upd.setPageSize(pagePost.getSize());
      
        return upd; 
		
//		List<UsersPageDetails> userPageDetails=allPosts.stream().map()
//		return usersPageDetails;
	}
	
	
	
	
	//pagination

//    public UserPageDetails findall(int pageNo,int pageSize,String sortBy,String SortDir){
//
//
//       Sort sortDirection= SortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
//
//       Pageable p=PageRequest.of(pageNo, pageSize,sortDirection);
//
//       Page<Users> page = userRepo.findAll(p);	
//
//       List<Users> content = page.getContent();
// 
//       UserPageDetails upd= new UserPageDetails();
//      
//       upd.setData(content);
//
//       upd.setPageNo(page.getNumber());
//
//       upd.setTotalData(page.getNumberOfElements());
//
//       upd.setPageSize(page.getSize());
//      
//        return upd;   
//
//   }

	public Optional<Users> getUserById(String uid) {
		return userRepo.findById(uid);
	}

	public ResponseEntity<Users> addUser(Users user) {
		 userRepo.save(user); 
		 return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	public ResponseEntity<Users> updateUser(Users user, String uid) {
		Optional<Users> optionaluser=userRepo.findById(uid);
        if (optionaluser.isPresent()) {
            Users updateuser = optionaluser.get();
		updateuser.setName(user.getName());
		updateuser.setEmail(user.getEmail());
		updateuser.setMobileNumber(user.getMobileNumber());
		
		Users save1 = userRepo.save(updateuser);  
        
		return new ResponseEntity<>(save1,HttpStatus.OK);
        }else {
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    	
} 


	public ResponseEntity<String> deleteUser(String uid) {
		   userRepo.deleteById(uid);
		   return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
	}

	

}
