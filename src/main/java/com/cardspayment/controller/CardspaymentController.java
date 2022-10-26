package com.cardspayment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cardspayment.entity.Coustomer;
import com.cardspayment.entity.Login;
import com.cardspayment.service.CardspaymentService;


@CrossOrigin
@RestController
@RequestMapping("/coustomer")

public class CardspaymentController {
	
	@Autowired
	private CardspaymentService cardspaymentService;
	public void CardspaymentService(CardspaymentService cardspaymentService) {
		this.cardspaymentService=cardspaymentService;
	}
	
	@PostMapping("/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	 public Login register(@Valid @RequestBody Login login) {
		return cardspaymentService.register(login);
	}
	
	@PostMapping("/login")
    public Login loginLogin(@RequestBody Login userdata){
		cardspaymentService.loginLogin(userdata);
        return userdata;
    }
	
	@PostMapping("/coustomerapi")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Integer coustomer(@RequestBody Coustomer coustomer) {
		cardspaymentService.coustomerdetails(coustomer);
		return coustomer.getId();
	}
}
