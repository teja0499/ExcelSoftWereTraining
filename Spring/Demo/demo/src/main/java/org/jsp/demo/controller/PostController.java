package org.jsp.demo.controller;

import org.jsp.demo.dto.Post;
import org.jsp.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	
	
	@GetMapping("/test")
	public String test()
	{
		System.out.println("test");
		postService.test();
		System.out.println("post working");
		return "post working";
	}
	
	
	
	
	
	@PostMapping("/save")
	public ResponseEntity<?> savePost(@RequestBody Post post) {
		
		try {
			
			Post newPost=postService.savePost(post);
			return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
//		return "ok";
	}
	
	
	

	
}
