package com.cardspayment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cardspayment.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	Login findByUsername(String username);

}
