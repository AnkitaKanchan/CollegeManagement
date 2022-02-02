package com.example.CollegeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CollegeManagement.Dao.Login;
import com.example.CollegeManagement.Dao.Student_Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	Login findByUsernameAndPassword(String username, String password);

}
 