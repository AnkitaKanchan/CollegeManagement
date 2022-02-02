package com.example.CollegeManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CollegeManagement.Dao.Faculty_Login;
import com.example.CollegeManagement.Repository.FLoginRepository;

@Service
public class FloginService {

	@Autowired
	private FLoginRepository repo;
  
  public Faculty_Login f_login(String username, String password) {
	  Faculty_Login user2 = repo.findByUsernameAndPassword(username, password);
  	return user2;
  }


	
}
