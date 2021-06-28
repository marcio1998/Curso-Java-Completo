package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User>findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado"));
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não Encontrado!");
		}
		return user;
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}


	
}
