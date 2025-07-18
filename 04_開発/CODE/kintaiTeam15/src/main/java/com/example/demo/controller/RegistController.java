package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.LoginSearchForm;

@Controller
// @RequiredArgsConstructor
public class RegistController {
	
	private final RegistService RegistService;

	/*--- 最初のリクエスト -------------------------*/
	@GetMapping("/regist-form")
	private String ShowRegistForm(Model model) {
	    model.addAttribute("loginSearchForm", new LoginSearchForm());
		return "regist";
	}
	
	@PostMapping("/login-auth")
	public String login(@Validated @ModelAttribute LoginSearchForm form, BindingResult result, Model model, HttpSession session) {
	    
	}

}
