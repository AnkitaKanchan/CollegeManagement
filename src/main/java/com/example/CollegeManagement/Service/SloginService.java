package com.example.CollegeManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CollegeManagement.Dao.Login;
import com.example.CollegeManagement.Dao.Student_Login;
import com.example.CollegeManagement.Repository.LoginRepository;
import com.example.CollegeManagement.Repository.SLoginRepository;

@Service
public class SloginService {
	
	@Autowired
	private SLoginRepository repo;
  
  public Student_Login slogin(String username, String password) {
	  Student_Login user1 = repo.findByUsernameAndPassword(username, password);
  	return user1;
  }

}
