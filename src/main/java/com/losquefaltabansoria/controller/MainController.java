package com.losquefaltabansoria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.losquefaltabansoria.model.Account;
import com.losquefaltabansoria.model.Post;
import com.losquefaltabansoria.service.AccountService;
import com.losquefaltabansoria.service.PostService;

@Controller
public class MainController {

	@Autowired
	private PostService postService;

	@Autowired
	private AccountService accountService;

	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}

	@GetMapping("/posts")
	public String getPosts(Model model) {
		List<Post> posts = postService.getAll();
		model.addAttribute("posts", posts);
		return "posts";
	}

	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable Long id, Model model) {
		Optional<Post> optionalPost = postService.getById(id);
		if (optionalPost.isPresent()) {
			Post post = optionalPost.get();
			model.addAttribute("post", post);
			return "post";
		} else {
			return "404";
		}
	}

	@GetMapping("/posts/new")
	public String createPost(Model model) {
		Optional<Account> optionalAccount = accountService.findByEmail("ricardo.yague.ruiz@gmail.com");
		if (optionalAccount.isPresent()) {
			Post post = Post.builder().account(optionalAccount.get()).build();
			model.addAttribute("post", post);
			return "post_new";
		} else {
			return "404";
		}
	}

	@PostMapping("/posts/new")
	public String saveNewPost(@ModelAttribute Post post) {
		postService.save(post);
		return "redirect:/posts/" + post.getId();
	}

}
