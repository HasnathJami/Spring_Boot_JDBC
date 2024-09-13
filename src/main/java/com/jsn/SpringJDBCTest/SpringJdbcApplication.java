package com.jsn.SpringJDBCTest;

import com.jsn.SpringJDBCTest.model.User;
import com.jsn.SpringJDBCTest.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		User user = context.getBean(User.class);
		user.setId(5);
		user.setName("Jami");
		user.setTech("Java");

		UserRepository userRepository = context.getBean(UserRepository.class);
		userRepository.save(user);
		System.out.println(userRepository.findALl());
	}

}
