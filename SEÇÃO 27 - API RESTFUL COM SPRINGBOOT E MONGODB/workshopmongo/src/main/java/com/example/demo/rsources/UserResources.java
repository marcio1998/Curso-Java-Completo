package com.example.demo.rsources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value ="/users")
public class UserResources {
	@Autowired
	private UserService userService;
	
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity <List<User>> findAll(){
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
}
