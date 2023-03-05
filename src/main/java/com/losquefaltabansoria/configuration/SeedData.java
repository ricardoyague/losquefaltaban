package com.losquefaltabansoria.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.losquefaltabansoria.model.Account;
import com.losquefaltabansoria.model.Post;
import com.losquefaltabansoria.service.AccountService;
import com.losquefaltabansoria.service.PostService;

@Component
public class SeedData implements CommandLineRunner {

	@Autowired
	PostService postService;
	@Autowired
	AccountService accountService;

	@Override
	public void run(String... args) throws Exception {
		List<Post> posts = postService.getAll();
		if (posts.isEmpty()) {
			Account account1 = Account.builder().email("admin@losquefaltabansoria.com").firstName("Ricardo").lastName("Yagüe").password("1234").build();
			accountService.save(account1);

			Post post1 = new Post();
			post1.setTitle("Post 1");
			post1.setSummary("Summary of post 1");
			post1.setBody("Description of Post 1");
			post1.setAccount(account1);
			Post post2 = Post.builder().title("Post 2").summary("Summary of post 2").body("Description of Post 2").account(account1).build();
			postService.save(post2);
			postService.save(post1);

		}
	}

}
