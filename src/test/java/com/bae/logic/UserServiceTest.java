package com.bae.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.repository.UserRepository;
import com.bae.util.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	UserServiceImpl service;

	@Mock
	UserRepository repository;

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

}
