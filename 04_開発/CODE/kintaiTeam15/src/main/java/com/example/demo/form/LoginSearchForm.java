package com.example.demo.form;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginSearchForm {
	
	@NotNull(message="入力してください。")
	private String Id;
	
	@NotNull(message="入力してください。")
	private String password;
}
