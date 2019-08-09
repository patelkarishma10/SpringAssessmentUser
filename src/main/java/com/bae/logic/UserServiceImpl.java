package com.bae.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.entity.User;
import com.bae.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	public UserRepository repository;

	@Autowired
	public UserServiceImpl(UserRepository repository) {

		this.repository = repository;

	}

	public UserServiceImpl() {

	}

	@Override
	public User createUser(User user) {
		return repository.save(user);
	}

}
