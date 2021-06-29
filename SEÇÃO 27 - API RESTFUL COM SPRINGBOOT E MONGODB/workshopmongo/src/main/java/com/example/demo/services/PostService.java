package com.example.demo.services;

import java.util.Date;
import java.util.List;

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
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 *60 *1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	



	
}
