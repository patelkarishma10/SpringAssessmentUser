package com.bae.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bae.repository.UserRepository;
import com.bae.util.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	UserServiceImpl service;

	@Mock
	UserRepository repository;

	@Mock
	RestTemplate restTemplate;

	@Mock
	JmsTemplate jmsTemplate;

	@Test
	public void getAUserTest() {
		Mockito.when(repository.findById((long) 3)).thenReturn(Constants.MOCK_USER_OBJECT3);
		assertEquals(Constants.MOCK_USER_OBJECT3, service.getAUser(3));
		Mockito.verify(repository).findById((long) 3);
	}

	@Test
	public void createUserTest() {
		Mockito.when(repository.save(Constants.MOCK_USER_OBJECT)).thenReturn(Constants.MOCK_USER_OBJECT);
		assertEquals(Constants.MOCK_USER_OBJECT, service.createUser(Constants.MOCK_USER_OBJECT));
		Mockito.verify(repository).save(Constants.MOCK_USER_OBJECT);
	}

	@Test
	public void searchTest() {

		Mockito.when(repository.findById((long) 1)).thenReturn(Constants.MOCK_USER_OBJECT3);
		String searchTerm = "search";
		Mockito.when(restTemplate.exchange("http://localhost:8089/search/find/" + searchTerm, HttpMethod.GET, null,
				String.class)).thenReturn(Constants.MOCK_USER_OBJECT4);
		String searchResult = Constants.MOCK_USER_OBJECT4.getBody();
		assertEquals(searchResult, service.search(1, searchTerm));
		Mockito.verify(repository).findById((long) 1);
	}

}
