package com.cardspayment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cardspayment.controller.CardspaymentController;
import com.cardspayment.entity.Coustomer;
import com.cardspayment.entity.Login;
import com.cardspayment.service.CardspaymentService;


@ExtendWith(MockitoExtension.class)
public class CardspaymentTestController {

	@Mock
	CardspaymentService cardspaymentService;
	@InjectMocks
	CardspaymentController cardspaymentController;
	
	@Test
	void testRegister() {
		Login login = new Login();
		login.setId(1);
		login.setPassword("trilok123");
		login.setUsername("trilok");
		login.setEmail("trilok@gmail.com");
		Mockito.when(cardspaymentService.register(login)).thenReturn(login);// mocking
		Login registeredId = cardspaymentController.register(login);
		assertEquals(1, registeredId);
	}
	
	@Test
	  void testLogin()  throws Exception{
        
        Login login = new Login();
        login.setUsername("login");
        login.setPassword("login");
        cardspaymentService.loginLogin(login);
        cardspaymentController.loginLogin(login);
       
	}
	
	@Test
	public void testcoustomer() {
		Coustomer coustomer = new Coustomer();
		coustomer.setId(18);
		coustomer.setName("trilok");
		coustomer.setAge(20);
		coustomer.setEmail("trilok@gmail.com");
		coustomer.setAddress("hyf flat no 2");
		coustomer.setPhonenumber(76740810);
		Mockito.when(cardspaymentService.coustomerdetails(coustomer)).thenReturn(coustomer);
		Integer postbookId = cardspaymentController.coustomer(coustomer);
		assertEquals(18, postbookId);
	}
}
