package com.example.CollegeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CollegeManagement.Dao.Faculty_Login;

@Repository
public interface FLoginRepository extends JpaRepository<Faculty_Login, Integer>{

	

	Faculty_Login findByUsernameAndPassword(String username, String password);

}