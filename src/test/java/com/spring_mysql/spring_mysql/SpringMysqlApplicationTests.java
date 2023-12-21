package com.spring_mysql.spring_mysql;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringMysqlApplicationTests {
	@Autowired
	private MainController controller;
	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

}
