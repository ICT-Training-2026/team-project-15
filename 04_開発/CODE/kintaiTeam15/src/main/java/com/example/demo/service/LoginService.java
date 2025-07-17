package com.example.demo.service;

import com.example.demo.entity.User;

public interface LoginService {

	User authenticate(String Id, String rawPassword);
}
