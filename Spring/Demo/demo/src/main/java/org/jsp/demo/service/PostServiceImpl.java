package org.jsp.demo.service;

import java.util.Date;

import org.jsp.demo.dto.Post;
import org.jsp.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	
	public void test()
	{
		System.out.println("service test method");
	}


	
	
	
	public Post savePost(Post post)
	{
		
		post.setLikeCount(0);
		post.setViewCount(0);
		post.setDate(new Date());
		
		return	postRepository.save(post);
		
		
//		 post;
	}
}
