package com.consumerrest.consumerrest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@ActiveProfiles("test")
class ConsumerrestApplicationTests {

	@Autowired
	private RestTemplate restTemplate;
	@Test 
	public void contextLoads(){
		assertNotNull(restTemplate);
	}

}
