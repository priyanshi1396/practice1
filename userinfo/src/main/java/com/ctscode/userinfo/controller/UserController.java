package com.ctscode.userinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctscode.userinfo.dto.UserDTO;
import com.ctscode.userinfo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
		System.out.println("received adduser request");
		UserDTO savedUser = userService.addUser(userDTO);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/fetchUserById/{UserId}")
	public ResponseEntity<UserDTO> fetchUserDetailsById(@PathVariable Integer UserId) {
	 return userService.fetchUserDetailsById(UserId);
	}
	
}
