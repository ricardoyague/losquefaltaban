package com.losquefaltabansoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.losquefaltabansoria.model.Account;
import com.losquefaltabansoria.model.Member;
import com.losquefaltabansoria.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String postLogin(Model model) {
		return "home";
	}

	@GetMapping("/register")
	public String getRegister(Model model) {
		//		Account account = new Account();
		Member member = new Member();
		model.addAttribute("member", member);
		return "register";
	}

	@PostMapping("/register")
	public String postRegister(@ModelAttribute Account account) {
		accountService.save(account);
		return "redirect:/";
	}
}
