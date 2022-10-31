package com.firstSBApp.app;

import database.Database;
import jwt.JwtProvider;
import model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

		/*
			User user1 = new User(123, "pepe", "123asd");
			String jwt1 = new JwtProvider().createToken(user1);
			System.out.println(jwt1);

			boolean isValid = new JwtProvider().validate(jwt1);
			System.out.println(isValid);

			String userName = new JwtProvider().getUserNameFromToken(jwt1);
			System.out.println(userName);
		*/
	}

}
