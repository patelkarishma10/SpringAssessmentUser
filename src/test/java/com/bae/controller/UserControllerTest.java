package com.bae.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.logic.UserService;
import com.bae.util.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	@InjectMocks
	UserController controller;

	@Mock
	UserService service;

	@Test
	public void getAUserTest() {
		Mockito.when(service.getAUser((long) 3)).thenReturn(Constants.MOCK_USER_OBJECT3);
		assertEquals(Constants.MOCK_USER_OBJECT3, controller.getAUser((long) 3));
		Mockito.verify(service).getAUser((long) 3);
	}

	@Test
	public void createUserTest() {
		Mockito.when(service.createUser(Constants.MOCK_USER_OBJECT)).thenReturn(Constants.MOCK_USER_OBJECT);
		assertEquals(Constants.MOCK_USER_OBJECT, controller.createUser(Constants.MOCK_USER_OBJECT));
		Mockito.verify(service).createUser(Constants.MOCK_USER_OBJECT);
	}

	@Test
	public void searchTest() {
		Mockito.when(service.search(1, "1")).thenReturn("search result");
		assertEquals("search result", controller.search((long) 1, "1"));
		Mockito.verify(service).search(1, "1");
	}

}
