package com.operation.management;

import com.operation.management.quinary.model.UserAccount;
import com.operation.management.quinary.repository.UserAccountRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
class ManagementApplicationTests {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Test
	void contextLoads() {
		System.out.println("test----------------------");
	}

	@Test
	void loginTest(){
		System.out.println("test----------------------");
		UserAccount userAccount =  userAccountRepository.findUser("rnjsgurwl", "E17FAA989EAF10878BA322853BE7E454C29E8F7A9B1EA4D52FBEB6FDA15487");
	
		System.out.println("test----------------------");
		System.out.println(userAccount.getEMP_ID());
	}

}
