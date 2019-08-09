package com.bae.logic;

import java.util.Optional;

import com.bae.entity.User;

public interface UserService {

	User createUser(User user);

	Optional<User> getAUser(long id);

	String search(long id, String searchTerm);

}
