package com.jpa.jpa;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {
	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return args -> {
			repository.save(new Customer("jack", "Nani"));
			repository.save(new Customer("jack1", "Nani1"));
			repository.save(new Customer("jack2","Nani2"));
			repository.save(new Customer("jack3","Nani3"));
		
			// fetch all customers'
			log.info("Customers found with findAll()");
			log.info("-------------------------------");
			repository.findAll().forEach(customer->{
				log.info(customer.toString());
			});
			log.info("");

			//fetch an individual customer by ID
			Optional<Customer> customer = repository.findById(1L);
			log.info("Customer found with findById(1L) ");
			log.info("-------------------------------");
			log.info(customer.toString());
			log.info("");

			//fetch customer by last name
			log.info("Customer find with findByLastName('Nani3')");
			repository.findByLastName("Nani3").forEach(nani->{
				log.info(nani.toString());
			});
			log.info("");
		};
	}
}
