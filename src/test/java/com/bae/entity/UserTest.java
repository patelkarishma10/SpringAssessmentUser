package com.bae.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {

	@Test
	public void userTest() {
		User user1 = new User(1, "user1", 1);

		user1.setId(2);
		user1.setName("testName");
		user1.setMemberNumber(2);

		assertEquals(2, user1.getId());
		assertEquals("testName", user1.getName());
		assertEquals(2, user1.getMemberNumber());
	}
}
