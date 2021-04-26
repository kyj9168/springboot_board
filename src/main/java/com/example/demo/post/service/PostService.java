package com.example.demo.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.post.domain.Post;
import com.example.demo.post.repository.PostRepository;

import java.time.LocalDateTime;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public Post test() {
		Post post = Post.builder()
				.name("준느")
				.createDate(LocalDateTime.now())
				.title("게시판 테스트")
				.description("게시판 본문").build();
		return postRepository.save(post);
	}

	public Post getPost(Long id) {
		return postRepository.findById(id).orElseGet(null);
	}
}
