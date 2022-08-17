package com.example.demo.productRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.model.Login;

public interface LoginRepo extends JpaRepository<Login, Integer>{

//	Login findByUsernameAndPassword(String username,String password);
	@Query("select login from Login login where login.username=?1")
	public Login getbyusername(String username);
	
	
	@Query("select login from Login login where login.password=?1")
	public Login getbypassword(String password);
}
