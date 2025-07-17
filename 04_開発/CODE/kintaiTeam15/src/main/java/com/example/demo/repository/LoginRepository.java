package com.example.demo.repository;

import com.example.demo.entity.User;

public interface LoginRepository {
	
	User equals(String Id, String hashedpassword);
}
