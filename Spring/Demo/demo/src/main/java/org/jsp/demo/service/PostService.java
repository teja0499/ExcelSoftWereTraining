package org.jsp.demo.service;

import org.jsp.demo.dto.Post;
import org.springframework.http.ResponseEntity;


public interface PostService {
	
	void test();
	Post savePost(Post post);
}
