package org.ibs.service_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories
public class ServiceExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceExampleApplication.class, args);
	}

	@RequestMapping("/")
	String hello() {
		return "Hello";
	}

}
