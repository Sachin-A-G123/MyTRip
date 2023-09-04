package com.example.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.entity.Users;
import com.example.entity.UsersPageDetails;
import com.example.service.UsersService;

@RequestMapping("/users")
@RestController
public class UsersController {
	
	@Autowired
	UsersService userService;
//	
//	@GetMapping
//	public ResponseEntity<List<Users>> getAllUsers(){
//		return userService.getAllUsers();
//	}
	
	
	@GetMapping
	public ResponseEntity<UsersPageDetails> getAllUsers(
			@RequestParam(value="pageNo",defaultValue="0",required=false)int pageNo,
			@RequestParam(value="pageSize",defaultValue="1",required=false)int pageSize 
			){
		UsersPageDetails allPost=this.userService.getAllUsers(pageNo, pageSize);
		return new ResponseEntity<UsersPageDetails>(allPost,HttpStatus.OK);
	}

   
	 //pagination
	
//   @GetMapping
//    public  ResponseEntity<UserPageDetails>  findall(@RequestParam(value="pageNo",defaultValue = "0",required=false)int pageno,
//
//                            @RequestParam(value="pageSize",defaultValue = "10",required=false)int pageSize,
//
//                            @RequestParam(value="sortBy",defaultValue = "name",required=false) String sortBy,
//
//                               @RequestParam(value="sortDir",defaultValue ="asc",required=false) String sortDir){
//
//
//	   UserPageDetails allUser = userService.findall(pageno,pageSize,sortBy,sortDir);
//  return new ResponseEntity<>(allUser,HttpStatus.OK);
//
//}
	
	
	@GetMapping("/{uid}")
	public ResponseEntity<Users> getUserDetail(@PathVariable String uid) {
	     Optional<Users> user = userService.getUserById(uid);
//	    return ResponseEntity.ok(user);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get()); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
	}
	
	
	
	@PostMapping
	public ResponseEntity<Users> addUser(@RequestBody Users user){
		return  userService.addUser(user);
	}
	
	@PutMapping("/{uid}")
	public ResponseEntity<Users> updateUser(@RequestBody Users user,@PathVariable String uid){
		return userService.updateUser(user,uid);
	}
	
	
	@DeleteMapping("/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable String uid){
		return userService.deleteUser(uid);
	}
	
}
