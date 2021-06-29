package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	

	
	public Post findById(String id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado"));
		return post;
	}
	



	
}
