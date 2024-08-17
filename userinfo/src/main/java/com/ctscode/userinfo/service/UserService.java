package com.ctscode.userinfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctscode.userinfo.dto.UserDTO;
import com.ctscode.userinfo.entity.User;
import com.ctscode.userinfo.mapper.UserMapper;
//import com.ctscode.userinfo.repo.UserRepo;
//import com.ctscode.userinfo.repo.UserRepo;
//import com.ctscode.userinfo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	com.ctscode.userinfo.repo.UserRepo userRepo;

	public UserDTO addUser(UserDTO userDTO) {
	User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
	}

	public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
		// TODO Auto-generated method stub
		Optional<User> fetchedUser = userRepo.findById(userId);
		if(fetchedUser.isPresent()) 
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()), HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}

}
