package com.bae.logic;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.SearchLog;
import com.bae.entity.User;
import com.bae.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	public UserRepository repository;
	private RestTemplate restTemplate;
	private JmsTemplate jmsTemplate;

	@Autowired
	public UserServiceImpl(UserRepository repository, RestTemplate restTemplate, JmsTemplate jmsTemplate) {

		this.repository = repository;
		this.restTemplate = restTemplate;
		this.jmsTemplate = jmsTemplate;

	}

	public UserServiceImpl() {

	}

	@Override
	public User createUser(User user) {
		return repository.save(user);
	}

	@Override
	public String search(long id, String searchTerm) {
		Optional<User> userOp = repository.findById(id);
		if (userOp.isPresent()) {
			ResponseEntity<String> search = restTemplate.exchange("http://localhost:8089/search/find/" + searchTerm,
					HttpMethod.GET, null, String.class);
			String searchResult = search.getBody();
			User user = userOp.get();
			Date date = new Date();
			sendToQueue(user, searchTerm, date);
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

	private void sendToQueue(User user, String searchTerm, Date date) {
		SearchLog accountToStore = new SearchLog(user, searchTerm, date);
		jmsTemplate.convertAndSend("UserQueue", accountToStore);
	}

}
