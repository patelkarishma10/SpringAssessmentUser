package com.bae.logic;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.User;
import com.bae.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	public UserRepository repository;
	private RestTemplate restTemplate;

	@Autowired
	public UserServiceImpl(UserRepository repository, RestTemplate restTemplate) {

		this.repository = repository;
		this.restTemplate = restTemplate;

	}

	public UserServiceImpl() {

	}

	@Override
	public User createUser(User user) {
		return repository.save(user);
	}

	@Override
	public String search(long id, String searchTerm) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			ResponseEntity<String> search = restTemplate.exchange("http://localhost:8089/search/find/" + searchTerm,
					HttpMethod.GET, null, String.class);
			String searchResult = search.getBody();
			return searchResult;

		} else {
			return "{\"message\": \"user cannot be found\"}";
		}

	}

	@Override
	public Optional<User> getAUser(long id) {
		Optional<User> user = repository.findById(id);
		return user;
	}

}
