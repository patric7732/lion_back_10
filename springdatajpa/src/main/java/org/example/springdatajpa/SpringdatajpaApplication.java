package org.example.springdatajpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringdatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserRepository repository){
		return args -> {
//			//create
//			User user = new User("hong","hong@example.com");
//			repository.save(user);
//			log.info("사용자 추가 : "+ user.getName());
//			log.info("사용자 아이디 : " + user.getId());
//
//			//delete
//
//			repository.delete(user);
//			log.info("사용자 삭제 : "+ user.getName());

//			List<User> users = repository.findByName("kim");
//
//			users.forEach(user -> log.info(user.getName()+"::"+user.getEmail()));
		};
	}
}
