package com.example.demo.post.controller;

import com.example.demo.post.domain.Post;
import com.example.demo.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private PostService postService;

	@GetMapping("/db-test")
	public Post db() {
		return postService.test();
	}

	@GetMapping("/{id}")
	public Post getPost(@PathVariable Long id) {
		return postService.getPost(id);
	}

}
