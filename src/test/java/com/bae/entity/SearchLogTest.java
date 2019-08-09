package com.bae.entity;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class SearchLogTest {

	@Test
	public void searchLogTest() {
		Date date = new Date();
		User user1 = new User(1, "user1", 1);
		SearchLog searchLog = new SearchLog(user1, "searchTerm", date);

		searchLog.setSearchTerm("newSearch");
		searchLog.setId(1);

		assertEquals(1, searchLog.getId());
		assertEquals("newSearch", searchLog.getSearchTerm());
	}
}
