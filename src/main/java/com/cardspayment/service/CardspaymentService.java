package com.cardspayment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cardspayment.entity.Coustomer;
import com.cardspayment.entity.Login;
import com.cardspayment.repository.CardspaymentRepository;
import com.cardspayment.repository.LoginRepository;

@Configuration
@Service

public class CardspaymentService {
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private CardspaymentRepository cardspaymentRepository;
	public CardspaymentService(LoginRepository loginRepository, CardspaymentRepository cardspaymentRepository) {
		this.loginRepository=loginRepository;
		this.cardspaymentRepository=cardspaymentRepository;
	}
	
	public Login register(Login login) {
		return loginRepository.save(login);	
	}
	
	@SuppressWarnings("unchecked")
    public ResponseEntity<Login> loginLogin(@RequestBody Login userdata) {
		Login login = loginRepository.findByUsername(userdata.getUsername());
        if(login.getPassword().equals(userdata.getPassword()))
            return ResponseEntity.ok(login);
        return (ResponseEntity<Login>) ResponseEntity.internalServerError();
    }
		
	public Coustomer coustomerdetails(Coustomer coustomer) {
		// TODO Auto-generated method stub
		cardspaymentRepository.save(coustomer);
		return coustomer;
	}
	
}

