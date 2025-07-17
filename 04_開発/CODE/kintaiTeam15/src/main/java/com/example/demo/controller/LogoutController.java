package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.form.LoginSearchForm;

@Controller
public class LogoutController {
	
	@GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        // セッション情報を破棄してログアウト
        session.invalidate();
        
        model.addAttribute("loginSearchForm", new LoginSearchForm());
        
        // ログイン画面へリダイレクト
        return "login";
    }
}
