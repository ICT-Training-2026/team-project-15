package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.form.LoginSearchForm;
import com.example.demo.service.LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService loginService;

	/*--- 最初のリクエスト -------------------------*/
	@GetMapping("/login")
	private String ShowTop(Model model) {
	    model.addAttribute("loginSearchForm", new LoginSearchForm());
		return "login";
	}
	
	@PostMapping("/login-auth")
	public String login(@Validated @ModelAttribute LoginSearchForm form, BindingResult result, Model model, HttpSession session) {
	    if(result.hasErrors()) {
	        return "login";
	    }
	    
	    User authenticatedUser = loginService.authenticate(form.getId(), form.getPassword());
	    if (authenticatedUser != null) {
	    	// セッションにIDとNAMEを保存
	        session.setAttribute("userId", authenticatedUser.getId());
	        session.setAttribute("userName", authenticatedUser.getName());
            return "top"; 
        } else {
            model.addAttribute("msg", "社員番号またはパスワードが正しくありません");
            return "login";
        }
	}

}
