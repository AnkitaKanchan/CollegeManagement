package com.example.CollegeManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CollegeManagement.Dao.Login;
import com.example.CollegeManagement.Repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;
  
  public Login login(String username, String password) {
	  Login user = repo.findByUsernameAndPassword(username, password);
  	return user;
  }
	
}
