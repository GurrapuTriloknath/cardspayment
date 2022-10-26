package com.cardspayment;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cardspayment.entity.Coustomer;
import com.cardspayment.entity.Login;
import com.cardspayment.repository.CardspaymentRepository;
import com.cardspayment.repository.LoginRepository;
import com.cardspayment.service.CardspaymentService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CardspaymentTestService {
	@InjectMocks
	CardspaymentService cardspaymentService;
	@Mock
	CardspaymentRepository cardspaymentRepository;
	@Mock
	LoginRepository loginRepository;
	
    @Test
    void testRegister() {
    	Login login = new Login();
    	login.setId(1);
		login.setPassword("trilok123");
		login.setUsername("trilok");
		login.setEmail("trilok@gmail.com");
		when(loginRepository.save(login)).thenReturn(login);//mock
		cardspaymentService.register(login);
		assertEquals(1,	login.getId());
    }
   
	@Test
	void testLogin() {
		Login login = new Login();
		login.setId(1);
		login.setPassword("trilok123");
		login.setUsername("trilok");
		login.setEmail("trilok@gmail.com");
		cardspaymentService.loginLogin(login);
//    	cardspaymentController.loginLogin(login);
		
	}
	
	  @Test
	    public void testcoustomerapi() {
		  Coustomer coustomer = new Coustomer();
			coustomer.setId(18);
			coustomer.setName("trilok");
			coustomer.setAge(20);
			coustomer.setEmail("trilok@gmail.com");
			coustomer.setAddress("hyf flat no 2");
			coustomer.setPhonenumber(76740810);
			when(cardspaymentRepository.save(coustomer)).thenReturn(coustomer);
			cardspaymentService.coustomerdetails(coustomer);
			assertEquals(18, coustomer.getId());
	    }
}
