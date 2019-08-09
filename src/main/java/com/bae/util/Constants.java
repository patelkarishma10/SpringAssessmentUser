package com.bae.util;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.bae.entity.User;

@Component
public class Constants {

	public static final User MOCK_USER_OBJECT = new User(1, "user1", 1);
	public static final User MOCK_USER_OBJECT2 = new User(2, "user2", 2);
	public static final Optional<User> MOCK_USER_OBJECT3 = Optional.of(MOCK_USER_OBJECT);
	public static final ResponseEntity<String> MOCK_USER_OBJECT4 = new ResponseEntity<String>("search", HttpStatus.OK);
}
