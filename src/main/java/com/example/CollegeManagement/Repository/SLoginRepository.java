package com.example.CollegeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CollegeManagement.Dao.Student_Login;

public interface SLoginRepository extends JpaRepository<Student_Login, Integer>{

	Student_Login findByUsernameAndPassword(String username, String password);


	
 
	


}


